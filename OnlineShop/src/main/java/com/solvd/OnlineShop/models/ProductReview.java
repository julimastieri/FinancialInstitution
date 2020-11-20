package com.solvd.OnlineShop.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductReview extends AbstractEntity {
	
	private String title;
	private String rating;
	private String content;
	private Product product;
	
	public ProductReview() {
	}

	public ProductReview(long id, String title, String rating, String content, Product product) {
		super(id);
		this.title = title;
		this.rating = rating;
		this.content = content;
		this.product = product;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
