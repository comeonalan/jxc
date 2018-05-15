package com.gyl.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	//{CascadeType.REMOVE,CascadeType.MERGE} 
	//,fetch=FetchType.EAGER
	/**
	 * A为父对象，持有一个B的集合，A与B的关系为oneToMany. 
第一次保存：设置A下的B集合成员为：1,2,3, 保存A后，B对象对应的数据表为:1,2,3
第二次保存：设置A下的B集合成员为：2,3,4, 保存A后，B对象对应的数据表为:2,3,4 (自动删除无效数据1)
这个就是自动去孤子功能。
	 */
	@OneToMany(mappedBy = "order",cascade =CascadeType.ALL,orphanRemoval=true)
	private Set<OrderItem> orderItems;
	
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

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}



}
