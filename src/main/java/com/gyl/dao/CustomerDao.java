package com.gyl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gyl.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {
    public Customer findByNameAndSexAndAddressAndTelephone(String name,String sex,String address,String telephone);
}
