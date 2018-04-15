package com.gyl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gyl.entity.Shop;

@Repository
public interface ShopDao  extends JpaRepository<Shop, Integer> {

}
