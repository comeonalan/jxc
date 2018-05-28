package com.gyl.formbean;

import java.util.ArrayList;
import java.util.List;

import com.gyl.entity.OrderItem;

public class OrderDetail {
	// 厂家名称
	private String venderName;
	//出售总价
	private float sellTotalPrice;
	
	private float venderTotalPrice;
	
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public String getVenderName() {
		return venderName;
	}

	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}

	public float getSellTotalPrice() {
		return sellTotalPrice;
	}

	public void setSellTotalPrice(float sellTotalPrice) {
		this.sellTotalPrice = sellTotalPrice;
	}

	public float getVenderTotalPrice() {
		return venderTotalPrice;
	}

	public void setVenderTotalPrice(float venderTotalPrice) {
		this.venderTotalPrice = venderTotalPrice;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	
	
}
