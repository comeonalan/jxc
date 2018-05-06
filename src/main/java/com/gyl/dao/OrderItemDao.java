package com.gyl.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gyl.entity.OrderItem;

@Transactional(readOnly = true)
@Repository
public interface OrderItemDao extends JpaRepository<OrderItem,Long>{
	    
	    @Transactional(readOnly = false)
	    @Modifying  //modify将会将事务readonly 设置为false
	    @Query("delete from OrderItem o where o.id in :ids ")
		public void deleteOrderItemsByIds(@Param("ids")Set<Long> idSet);
	    
	    @Query("select o from OrderItem o where o.productType = :productType and o.order.id = :id ")
	    public List<OrderItem> findByProductTypeAndOrderId(@Param("productType")String productType,@Param("id")long id);
	 
	 
}
