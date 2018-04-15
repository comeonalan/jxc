package com.gyl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyl.dao.ShopDao;
import com.gyl.entity.Shop;

@Service
public class ShopService {

	@Autowired
	private ShopDao shopDao;
	
	public Shop addShop(Shop shop) {
		return shopDao.save(shop);
	}
}
