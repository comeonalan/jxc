package com.gyl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gyl.entity.Customer;
import com.gyl.service.CustomerService;

@RequestMapping("/customer")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/addNewCustomer")
	public String addNewCustomer(@RequestBody @Validated Customer customer, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.print(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage());
				throw new Exception(error.getDefaultMessage());
				//return error.getDefaultMessage();
			}
		}

		try {
			Customer returnedCustomer = customerService.getCustomerByNameAndSexAndAddressAndTelephone(customer);
			if (returnedCustomer != null) {
				return "客户已存在";
				//throw new Exception("客户已存在");
			}
			customerService.addCustomer(customer);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
			//return "添加客户失败！";
		}
		return "添加客户成功！";
	}
	
//	@GetMapping("/queryAllCustomers")
//	public Map<String, List<Customer>> queryAllCustomers() {
//		List<Customer> customers =customerService.getAllCustomer();
//		Map<String,List<Customer>> map = new HashMap<String,List<Customer>>();
//		map.put("customers", customers);
//		return map;
//	}
	
	@GetMapping("/getCustomersByName")
	public Map<String, List<Customer>> getCustomersByName(String name) {
		List<Customer> customers =customerService.getCustomersByName(name);
		Map<String,List<Customer>> map = new HashMap<String,List<Customer>>();
		map.put("customers", customers);
		return map;
	}
	
	@DeleteMapping("/deleteCustomerById")
	public String deleteCustomerById(long id) {
		  try {
			  customerService.deleteCustomerById(id);
		  }catch(Exception e) {
			   System.out.println("删除客户错误信息--》"+e);
			  return "删除客户失败!"; 
		  }
		  return "删除客户成功!"; 
	}
	
	
	@DeleteMapping("/deleteCustomersByIds")
	public String deleteCustomersByIds(String ids) {
		  try {
			  customerService.deleteCustomersByIds(ids);
		  }catch(Exception e) {
			   System.out.println("批量删除客户错误信息--》"+e);
			  return "批量删除客户失败!"; 
		  }
		  return "批量删除客户成功!"; 
	}
	
	@PatchMapping("/modifyCustomer")
	public String modifyCustomer(@RequestBody Customer customer) throws Exception {
	    try {
	    	customerService.modifyCustomerInfo(customer);
	    }catch(Exception e) {
	    	 System.out.println("更新客户错误信息--》"+e);
	    	 return "更新客户信息失败！";
	    }
	    return "更新客户信息成功！";
	
	}


}
