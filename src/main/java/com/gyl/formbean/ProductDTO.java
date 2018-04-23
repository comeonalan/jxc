package com.gyl.formbean;

public class ProductDTO {
 
	private long id;

	private String name;
    
 
	private String type;

 
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


	public ProductDTO(long id, String name, String type, String venderName) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.venderName = venderName;
	}
	
	public ProductDTO() {}
}
