package com.gyl.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * 
 * @author Alan 客户表
 */

//@JsonIgnoreProperties 防止产生死循环问题，因为Customer中有order，order中又有customer
@JsonIgnoreProperties(value={"orders"})  
@Table(name = "customer")
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private long id;
    
	@NotBlank(message="客户名字不能为空")
	private String name;

	private String sex;
    
	@NotBlank(message="客户地址不能为空")
	private String address;
	 
//	@Pattern(regexp="^[1][1-9]{2}[0-9]{8}$",message="{customer.telephone.message}")
	private String telephone;

	@OneToMany(mappedBy = "customer",cascade = {CascadeType.REMOVE,CascadeType.MERGE})
	private Set<Order> orders;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
