package com.gyl.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gyl.entity.Shop;

@Transactional(readOnly = true)
@Repository
public interface ShopDao  extends JpaRepository<Shop, Integer> {

    @Transactional(readOnly = false)
    @Modifying  //modify将会将事务readonly 设置为false
    @Query("delete from Shop shop where shop.id in :ids ")
    public void deleteShopsByIds(@Param("ids")Set<Integer> idSet);

	public List<Shop> findByNameIgnoreCaseContaining(String name);

}
