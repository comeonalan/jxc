package com.gyl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gyl.entity.Order;
//,PagingAndSortingRepository<Order,Long>

@Repository
public interface OrderDao extends JpaRepository<Order,Long>,JpaSpecificationExecutor<Order>{

}
