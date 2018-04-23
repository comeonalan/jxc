package com.gyl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author Alan 货物表
 */

@Table(name = "product")
@Entity
public class Product {

	@Id
	@GeneratedValue
	private long id;

	private String name;
    
	@NotBlank(message="货物型号不能为空")
	private String type;

	@ManyToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "vender_id")
	private Vender vender;

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

	public Vender getVender() {
		return vender;
	}

	public void setVender(Vender vender) {
		this.vender = vender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
