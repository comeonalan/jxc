package com.gyl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gyl.entity.Vender;


@Repository
public interface VenderDao extends JpaRepository<Vender,Integer> {
	

//public Vender save(Vender vender);
}
