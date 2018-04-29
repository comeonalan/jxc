package com.gyl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@DeleteMapping("/deleteShopById")
	public String deleteShopById(int id) {
		  try {
			  shopService.deleteShopById(id);
		  }catch(Exception e) {
			   System.out.println("删除店铺错误信息--》"+e);
			  return "删除店铺失败!"; 
		  }
		  return "删除店铺成功!"; 
	}
	
	@DeleteMapping("/deleteShopsByIds")
	public String deleteShopsByIds(String ids) {
		  try {
			  shopService.deleteProductsByIds(ids);
		  }catch(Exception e) {
			   System.out.println("批量删除店铺错误信息--》"+e);
			  return "批量删除店铺失败!"; 
		  }
		  return "批量删除店铺成功!"; 
	}
	
	@PatchMapping("/modifyShop")
	public String modifyShop(@RequestBody Shop shop) {
	    try {
	    	shopService.modifyShopInfo(shop);
	    }catch(Exception e) {
	    	System.out.println(e);
	    	return "更新商品信息失败！";
	    }
	    return "更新商品信息成功！";
	
	}
	
	@GetMapping(value="/getShopsByName")
	public Map<String, List<Shop>> getShopsByName(@RequestParam(value="name",required=false) String name) {
		Map<String, List<Shop>> map = new HashMap<String, List<Shop>>();
		List<Shop> shops = shopService.getShopsByName(name);
		map.put("shops", shops);
		return map;
	}

}
