package com.solvd.OnlineShop.models;

public class Category extends AbstractEntity{

	private String name;
	
	public Category() {
	}

	public Category(long id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
