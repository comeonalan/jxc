package com.gyl.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gyl.entity.Order;
//,PagingAndSortingRepository<Order,Long>

@Transactional(readOnly = true)
@Repository
public interface OrderDao extends JpaRepository<Order,Long>,JpaSpecificationExecutor<Order>{

    @Transactional(readOnly = false)
    @Modifying  //modify将会将事务readonly 设置为false
    @Query("delete from Order o where o.id in :ids ")
	public void deleteOrdersByIds(@Param("ids")Set<Long> idSet);
}
