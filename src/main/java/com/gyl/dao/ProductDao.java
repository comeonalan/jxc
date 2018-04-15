package com.gyl.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gyl.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
//	public Product findProductById(Long id);
//
//	public List<Product> findAll();

}
