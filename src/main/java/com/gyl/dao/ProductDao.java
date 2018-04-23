package com.gyl.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.gyl.entity.Product;
import com.gyl.formbean.ProductDTO;

@Transactional(readOnly = true)
@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
//	public Product findProductById(Long id);
//
//	public List<Product> findAll();
//	@Query(value="select p.id,p.type, p.name,v.name as venderName from product p ,vender v where p.vender_id = v.id and p.type = :type",nativeQuery=true)
    @Query("select new com.gyl.formbean.ProductDTO(p.id,p.name,p.type,p.vender.name) from Product p where p.type like %:type%")
	public List<ProductDTO> findByType(@Param("type") String type);
}
