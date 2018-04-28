package com.gyl.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public void deleteShopById(int id) {
		shopDao.deleteById(id);
		
	}

	public void deleteProductsByIds(String ids) {
		String[] reIds =ids.split(",");
		Set<Integer> idSet = new HashSet<Integer>();
		for(String x : reIds) {
			idSet.add(Integer.parseInt(x));
		}
		shopDao.deleteShopsByIds(idSet);
	}

	public void modifyShopInfo(Shop shop) {
		 Shop  returnedShop = shopDao.getOne(shop.getId());
		 returnedShop.setName(shop.getName());
		 returnedShop.setAddress(shop.getAddress());
		 shopDao.save(returnedShop);
	}

	public List<Shop> getShopsByName(String name) {
		return shopDao.findByNameIgnoreCaseContaining(name);
	}
}
