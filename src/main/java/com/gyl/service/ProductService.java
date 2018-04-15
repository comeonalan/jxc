package com.gyl.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyl.dao.ProductDao;
import com.gyl.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public Product addProduct(Product product) {
		return productDao.save(product);
	}

//	public Product getProductById(Long id) {
//		return productDao.findProductById(id);
//	}
//	
//	public List<Product> getAllProducts(){
//		return productDao.findAll();
//	}
}
