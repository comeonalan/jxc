package com.gyl.formbean;

import javax.validation.constraints.NotBlank;

public class ProductDTO {
 
	private long id;

	private String name;
    
	@NotBlank(message="货物型号不能为空")
	private String type;
	

	private int venderId;

 
	private String venderName;


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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getVenderName() {
		return venderName;
	}


	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}

	public int getVenderId() {
		return venderId;
	}


	public void setVenderId(int venderId) {
		this.venderId = venderId;
	}


	public ProductDTO(long id, String name, String type, int venderId, String venderName) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.venderId = venderId;
		this.venderName = venderName;
	}


	public ProductDTO() {}
}
