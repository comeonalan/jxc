package com.gyl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyl.dao.CustomerDao;
import com.gyl.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public Customer addCustomer(Customer customer) {
		return customerDao.save(customer);
	}
	
	public Customer getCustomerByNameAndSexAndAddressAndTelephone(Customer customer) {
	 return customerDao.findByNameAndSexAndAddressAndTelephone(customer.getName(), customer.getSex(),customer.getAddress(), customer.getTelephone());
	}
	
	public List<Customer> getAllCustomer(){
		return customerDao.findAll();
	}
	
}
