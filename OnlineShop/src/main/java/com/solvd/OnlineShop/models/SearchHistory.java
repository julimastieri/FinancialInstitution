package com.solvd.OnlineShop.models;

import java.sql.Date;

public class SearchHistory extends AbstractEntity{
	
	private Date date;
	private Product product;

	public SearchHistory() {
	}
	
	public SearchHistory(long id, Date date) {
		super(id);
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	

}
