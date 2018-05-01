package com.gyl.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.springframework.data.annotation.CreatedDate;
/**
 * 
 * @author Alan 订单表
 */
//@JsonIgnoreProperties(value={"customer"})
//表名不能设置为order，因为order在db里是关键字
@Table(name = "t_order")
@Entity
public class Order {

	@Id
	@GeneratedValue
	private long id;

	// 店铺名称
	private String shopName;
		
	//下单日期（自动）
	//@CreatedDate
	private Date orderDate;
	
	//定金
	private float deposit;
	
	private String status;

	// 客户编号
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderDetail> orderDetails;
	
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


	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



}
