package com.gyl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gyl.entity.Order;
import com.gyl.formbean.OrderDTO;
import com.gyl.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/addNewOrders")
	public String addNewOrders(@RequestBody List<Order> orders) {
		try {
			orderService.addOrders(orders);
		} catch (Exception exception) {
			return "新增订单失败";
		}

		return "新增订单成功";

	}

	@GetMapping("/queryAllOrders")
	public Map<String, List<Order>> queryAllOrders() {
		//每一页显示10条数据。这里显示第一页（0）
		Page<Order> page = orderService.getAllOrders(0, 10);
		System.out.println("总条数：" + page.getTotalElements());
		System.out.println("总页数：" + page.getTotalPages());
		List<Order> list = new ArrayList<Order>();
		Iterator<Order> it=page.iterator(); 
	     while(it.hasNext()) {
	    	list.add( it.next());
	     }
//		List<Order> orders = page.getContent();
 		Map<String, List<Order>> map = new HashMap<String, List<Order>>();
		map.put("orders", list);
		return map;
	}
	
	@GetMapping("/getOrders")
	public Map<String, Object> getOrders(OrderDTO orderDTO,@RequestParam(value = "page", defaultValue = "1")int page){
		//每页5条数据
		int size = 5;
		Page<Order> orderPage =orderService.getOrdersByShopNameAndCustomerId(page-1,size,orderDTO);
		List<Order> orders = new ArrayList<Order>();
		Iterator<Order> it=orderPage.iterator(); 
	     while(it.hasNext()) {
	    	 orders.add( it.next());
	     }
//		List<Order> orders = page.getContent();
	     //总页面数
	    int total=orderPage.getTotalPages();
 		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orders", orders);
		map.put("total", total);
		return map;
	}

}
