package com.gyl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyl.entity.Shop;
import com.gyl.service.ShopService;

@RequestMapping("/shop")
@RestController
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@PostMapping("/addNewShop")
	public String addNewShop(@RequestBody Shop shop) {
		try {
			shopService.addShop(shop);
		}catch(Exception e) {
			return "新增店铺失败！";
		}
		return "新增店铺成功！";
	}

}
