package com.gyl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gyl.entity.Customer;
import com.gyl.service.CustomerService;

@RequestMapping("/customer")
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ResponseBody
	@PostMapping("/addNewCustomer")
	public String addNewCustomer(@RequestBody @Validated Customer customer, BindingResult result) {

		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.print(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage());
				return error.getDefaultMessage();
			}
		}

		try {
			Customer returnedCustomer = customerService.getCustomerByNameAndSexAndAddressAndTelephone(customer);
			if (returnedCustomer != null) {
				return "客户已存在";
			}
			customerService.addCustomer(customer);

		} catch (Exception e) {
			return "添加客户失败！";
		}
		return "添加客户成功！";
	}
	
	@ResponseBody
	@GetMapping("/queryAllCustomers")
	public Map<String, List<Customer>> queryAllCustomers() {
		List<Customer> customers =customerService.getAllCustomer();
		Map<String,List<Customer>> map = new HashMap<String,List<Customer>>();
		map.put("customers", customers);
		return map;
	}

}
