package com.solvd.OnlineShop.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import xmlAdapters.DateAdapter;

@XmlRootElement(name="search_history")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchHistory extends AbstractEntity{
	
	@XmlJavaTypeAdapter(DateAdapter.class)
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
