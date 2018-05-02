package com.gyl.service;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.gyl.entity.Order;
import com.gyl.formbean.OrderDTO;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public Order addOrder(Order order) {
		return orderDao.save(order);
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
}
