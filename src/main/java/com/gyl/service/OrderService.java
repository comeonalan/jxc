package com.gyl.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gyl.dao.OrderDao;
import com.gyl.dao.OrderItemDao;
import com.gyl.entity.Order;
import com.gyl.entity.OrderItem;
import com.gyl.formbean.OrderDTO;
import com.gyl.formbean.OrderDetail;
import com.gyl.formbean.OrderItemDTO;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	public Order addOrder(Order order) {
		return orderDao.save(order);
	}
	
	public Order updateOrder(Order order) {
		return orderDao.saveAndFlush(order);
	}
	
	public void addOrders(List<Order> orders) {
		orderDao.saveAll(orders);
	}
	
	public Page<Order> getAllOrders(int page,int size){
//		int page=1;
//		int size=10;
		Sort sort = new Sort(Direction.DESC,"orderDate");
		Pageable pageable =  PageRequest.of(page, size, sort);  
//		return orderDao.findAll(pageable).getContent();
		return orderDao.findAll(pageable);
		
	}
	
	public Page<Order> getOrdersByShopNameAndCustomerId(int page,int size,OrderDTO orderDTO){
		Set<Long> customerIdSet = new HashSet<Long>();
		Set<String> shopNameSet =  new HashSet<String>();
		
		String customerIds =orderDTO.getCustomerIds();
		if(!StringUtils.isEmpty(customerIds)) {
			String[] reIds =customerIds.split(",");
				for(String x : reIds) {
					customerIdSet.add(Long.parseLong(x));
				}
		}
		
		String shopNames  = orderDTO.getShopNames();
		if(!StringUtils.isEmpty(shopNames)) {
			String[] shopNameArray = shopNames.split(",");
			
			if(shopNameArray.length>0) {
				for(String y:shopNameArray) {
					shopNameSet.add(y);
				}
			}
		}
		
		
		Sort sort = new Sort(Direction.DESC,"orderDate");
		Pageable pageable =  PageRequest.of(page, size, sort); 
		Specification<Order> spec = new Specification<Order>() {

			@Override
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				 List<Predicate> list = new ArrayList<Predicate>();
				 if(customerIdSet.size()>0) {
					 In<Object> in = cb.in(root.get("customer").get("id"));
					  for(Long id:customerIdSet) {
						  in.value(id);
					  }
					  list.add(in);
				 }
				 if(shopNameSet.size()>0) {
					 In<Object> in2 = cb.in(root.get("shopName"));
					 for(String s:shopNameSet) {
						 in2.value(s);
					 }
					 list.add(in2);
				 }
				 Predicate[] p = new Predicate[list.size()];  
			     return cb.and(list.toArray(p));  
			}
			
		};
		return orderDao.findAll(spec, pageable);
	}

	public void modifyOrderInfo(Order order) {
	 Order returnedOrder = orderDao.getOne(order.getId());
	 if(returnedOrder!=null) {
		 returnedOrder.setDeposit(order.getDeposit());
		 returnedOrder.setOrderDate(order.getOrderDate());
		 returnedOrder.setStatus(order.getStatus());
		 orderDao.save(returnedOrder);
	 }
		
	}

	public void deleteOrderById(long id) {
		orderDao.deleteById(id);
	}

	public void deleteOrdersByIds(String ids) {
		String[] reIds =ids.split(",");
		Set<Long> idSet = new HashSet<Long>();
		for(String x : reIds) {
			idSet.add(Long.parseLong(x));
		}
		orderDao.deleteOrdersByIds(idSet);
		
	}
	
	public Order findOrderById(long id) {
		return orderDao.findById(id).get();
	}
	
	public Order getOrderById(long id) {
		return orderDao.getOne(id);
	}
	
	public List<OrderDetail> getOrderItemsByOrderId(long id){
		Order order = getOrderById(id);
		List<OrderItem> list = transferSetToList(order.getOrderItems());
		Set<String> venders = new HashSet<String>();;
		for(OrderItem orderItem:list) {
			if(!venders.contains(orderItem.getVenderName())) {
				venders.add(orderItem.getVenderName());
			}
		}
		
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		for(String vender:venders) {
			OrderDetail orderDetail = new OrderDetail();
			
			float sellTotalPrice = 0;
			float venderTotalPrice = 0;
			for(OrderItem orderItem: list) {
				
				if(orderItem.getVenderName().equals(vender)) {
					orderDetail.getItems().add(orderItem);
					sellTotalPrice += orderItem.getSellTotalPrice();
					venderTotalPrice +=orderItem.getVenderTotalPrice();
				}
				
			}
			orderDetail.setVenderName(vender);
			orderDetail.setVenderTotalPrice(Math.round(venderTotalPrice));
			orderDetail.setSellTotalPrice(Math.round(sellTotalPrice));
			orderDetails.add(orderDetail);
			
		}
		 
		return orderDetails;
	}
	
	private List<OrderItem> transferSetToList(Set<OrderItem> set) {
		List<OrderItem> list= new ArrayList<OrderItem>();
	    Iterator<OrderItem> it =set.iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void addOrderItem(OrderItem orderItem,long orderId) {
	 
		Order order = orderDao.findById(orderId).get();
		orderItem.setOrder(order);
 
		Set<OrderItem> set = order.getOrderItems();
		set.add(orderItem);
		order.setOrderItems(set);
		orderDao.save(order);
	}
	
	public OrderItem getOrderItemById(long id) {
		return orderItemDao.findById(id).get();
	}
	
	public void deleteOrderItemById(long id) {
		orderItemDao.deleteById(id);
	}
	
	public void deleteOrderItemsByIds(String ids) {
		String[] reIds =ids.split(",");
		Set<Long> idSet = new HashSet<Long>();
		for(String x : reIds) {
			idSet.add(Long.parseLong(x));
		}
		orderItemDao.deleteOrderItemsByIds(idSet);
		
	}

	public void modifyOrderInfo(OrderItemDTO orderItemDTO, long orderId) {
		OrderItem returnedOrderItem	= orderItemDao.findById(orderItemDTO.getId()).get();
		returnedOrderItem.setProductType(orderItemDTO.getProductType());
		returnedOrderItem.setQuantity(orderItemDTO.getQuantity());
		returnedOrderItem.setSellUnitPrice(orderItemDTO.getSellUnitPrice());
		returnedOrderItem.setVenderUnitPrice(orderItemDTO.getVenderUnitPrice());
		returnedOrderItem.setVenderName(orderItemDTO.getVenderName());
		 float venderTotalPrice = orderItemDTO.getVenderUnitPrice()*orderItemDTO.getQuantity();
		 returnedOrderItem.setVenderTotalPrice(venderTotalPrice);
		 float SellTotalPrice = orderItemDTO.getSellUnitPrice() * orderItemDTO.getQuantity();
		 returnedOrderItem.setSellTotalPrice(SellTotalPrice);
		 float profit = SellTotalPrice - venderTotalPrice;
		 returnedOrderItem.setProfit(profit);
		 
		 orderItemDao.save(returnedOrderItem);
	}

	 public List<OrderItem> getOrderItemsByProductTypeAndOrderId(String productType,long id){
		return  orderItemDao.findByProductTypeAndOrderId(productType, id);
	 }
	
}
