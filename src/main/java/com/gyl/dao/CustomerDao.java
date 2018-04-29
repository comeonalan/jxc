package com.gyl.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gyl.entity.Customer;

@Transactional(readOnly = true)
@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {
    public Customer findByNameAndSexAndAddressAndTelephone(String name,String sex,String address,String telephone);

    public List<Customer> findByNameIgnoreCaseContaining(String name);
    
    @Transactional(readOnly = false)
    @Modifying  //modify将会将事务readonly 设置为false
    @Query("delete from Customer customer where customer.id in :ids ")
	public void deleteCustomersByIds(@Param("ids")Set<Long> idSet);
}
