package com.gyl.service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyl.dao.ProductDao;
import com.gyl.entity.Product;
import com.gyl.formbean.ProductDTO;

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
	
	public void deleteProductById(long id) {
		productDao.deleteById(id);
	}
	
	public void deleteProductsByIds(String ids) {
		String[] reIds =ids.split(",");
		Set<Long> idSet = new HashSet<Long>();
		for(String x : reIds) {
			idSet.add(Long.parseLong(x));
		}
		productDao.deleteProductsByIds(idSet);
	}

	public void modifyProductInfo(ProductDTO productDTO) {
		 Product returnedProduct = productDao.getOne(productDTO.getId());
		 if(returnedProduct!=null) {
			 returnedProduct.setName(productDTO.getName());
			 returnedProduct.setType(productDTO.getType());
			 productDao.save(returnedProduct);
		 }
		
	}
}
