package com.gyl.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Alan 订单表
 */
@JsonIgnoreProperties(value={"customer"})
//表名不能设置为order，因为order在db里是关键字
@Table(name = "t_order")
@Entity
public class Order {

	@Id
	@GeneratedValue
	private long id;

	// 货物型号
	private String productType;

	// 厂家名称
	private String venderName;

	// 货物数量
	private int quantity;

	// 厂家单价
	private float venderUnitPrice;

	// 出售单价
	private float sellUnitPrice;

	// 店铺名称
	private String shopName;
	
	//厂家总价
	private float venderTotalPrice;
	
	//出售总价
	private float sellTotalPrice;
	
	//每单利润
	private float profit;
	
	//下单日期（自动）
	@CreatedDate
	private Date orderDate;

	// 客户编号
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
//	public Order() {
//	  System.out.print("无参构造器");
//	}
//	public Order(String productType, String venderName, int quantity, float venderUnitPrice, float sellUnitPrice,
//			String shopName, Date orderDate, Customer customer) {
//		super();
//		this.productType = productType;
//		this.venderName = venderName;
//		this.quantity = quantity;
//		this.venderUnitPrice = venderUnitPrice;
//		this.sellUnitPrice = sellUnitPrice;
//		this.shopName = shopName;
//		this.orderDate = orderDate;
//		this.customer = customer;
//		this.sellTotalPrice=sellUnitPrice*quantity;
//		this.venderTotalPrice = venderUnitPrice * quantity;
//		this.profit = (sellUnitPrice-venderUnitPrice) * quantity;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

 

	public void setVenderTotalPrice(float venderTotalPrice) {
		this.venderTotalPrice = this.getVenderUnitPrice() * this.getQuantity();
		//this.venderTotalPrice = venderTotalPrice;
	}

	public void setSellTotalPrice(float sellTotalPrice) {
		this.sellTotalPrice = this.getSellUnitPrice() * this.getQuantity();
	}

	public void setProfit(float profit) {
		this.profit = (this.getSellUnitPrice()-this.getVenderUnitPrice()) * this.getQuantity();
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

}
