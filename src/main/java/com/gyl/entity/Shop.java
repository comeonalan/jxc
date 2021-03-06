package com.gyl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author Alan 店铺表
 */

@Table(name = "shop")
@Entity
public class Shop {
	@Id
	@GeneratedValue
	private int id;
    
	@NotBlank(message="店铺名称不能为空")
	private String name;

	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
