package com.gyl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gyl.dao.OrderDao;
import com.gyl.entity.Order;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	
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
}
