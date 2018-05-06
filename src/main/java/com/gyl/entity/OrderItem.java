package com.gyl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 订单详情表
 * @author Alan
 *
 */
@JsonIgnoreProperties(value={"order"})
@Table(name = "t_order_item")
@Entity
public class OrderItem {

  //订单详情id
  @Id
  @GeneratedValue
  private long id ;
  
  //货物型号
	private String productType;

	// 厂家名称
	private String venderName;

	// 货物数量
	private int quantity;

	// 厂家单价
	private float venderUnitPrice;

	// 出售单价
	private float sellUnitPrice;
	
	//厂家总价
	private float venderTotalPrice;
	
	//出售总价
	private float sellTotalPrice;
	
	//每单利润
	private float profit;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
  
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getVenderName() {
		return venderName;
	}

	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getVenderUnitPrice() {
		return venderUnitPrice;
	}

	public void setVenderUnitPrice(float venderUnitPrice) {
		this.venderUnitPrice = venderUnitPrice;
	}

	public float getSellUnitPrice() {
		return sellUnitPrice;
	}

	public void setSellUnitPrice(float sellUnitPrice) {
		this.sellUnitPrice = sellUnitPrice;
	}
	
	public void setVenderTotalPrice(float venderTotalPrice) {
	//	this.venderTotalPrice = this.getVenderUnitPrice() * this.getQuantity();
		 this.venderTotalPrice = venderTotalPrice;
	}

	public void setSellTotalPrice(float sellTotalPrice) {
		//this.sellTotalPrice = this.getSellUnitPrice() * this.getQuantity();
		this.sellTotalPrice = sellTotalPrice;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	//	this.profit = (this.getSellUnitPrice()-this.getVenderUnitPrice()) * this.getQuantity();
	}
	
	public float getVenderTotalPrice() {
		return venderTotalPrice;
	}

	public float getSellTotalPrice() {
		return sellTotalPrice;
	}

	public float getProfit() {
		return profit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
