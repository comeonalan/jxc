package com.gyl.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
//	public List<Customer> getAllCustomer(){
//		return customerDao.findAll();
//	}

	public List<Customer> getCustomersByName(String name) {
		return customerDao.findByNameIgnoreCaseContaining(name);
	}

	public void deleteCustomerById(long id) {
		customerDao.deleteById(id);
	}

	public void deleteCustomersByIds(String ids) {
		String[] reIds =ids.split(",");
		Set<Long> idSet = new HashSet<Long>();
		for(String x : reIds) {
			idSet.add(Long.parseLong(x));
		}
		customerDao.deleteCustomersByIds(idSet);
		
	}

	public void modifyCustomerInfo(Customer customer) {
		Customer returnedCustomer = customerDao.getOne(customer.getId());
		if(returnedCustomer!=null) {
			//returnedCustomer.setName(customer.getName());
			returnedCustomer.setAddress(customer.getAddress());
			returnedCustomer.setSex(customer.getSex());
			returnedCustomer.setTelephone(customer.getTelephone());
			customerDao.save(returnedCustomer);
		}
		
	}

	 public Customer getCustomerById(long id) {
		 return customerDao.getOne(id);
	 }
	
}
