package com.gyl.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyl.dao.ProductDao;
import com.gyl.entity.Product;
import com.gyl.formbean.ProductDTO;
import com.mysql.jdbc.StringUtils;

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
	public List<ProductDTO> getProductsByType(String type){
//		if(StringUtils.isNullOrEmpty(type)) {
//			return
//		}
		return productDao.findByType(type);
	}
}
