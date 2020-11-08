package com.solvd.OnlineShop.models;

public class Preference extends AbstractEntity{
	
	private Category category;
	
	public Preference() {
	}

	public Preference(long id) {
		super(id);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
