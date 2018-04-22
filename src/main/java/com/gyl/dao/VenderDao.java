package com.gyl.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gyl.entity.Vender;

@Transactional(readOnly = true)
@Repository
public interface VenderDao extends JpaRepository<Vender,Integer> {
//@Query("select vender from Vender vender where vender.name like %:name% ")
 
public List<Vender> findByNameIgnoreCaseContaining(String name);
//public Vender save(Vender vender);

@Transactional
@Modifying  //modify将会将事务readonly 设置为false
@Query("delete from Vender vender where vender.id in :ids ")
public void deleteVendersByIds(@Param("ids")Set<Integer> idSet);

}
