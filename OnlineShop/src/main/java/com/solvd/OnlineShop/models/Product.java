package com.solvd.OnlineShop.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product extends AbstractEntity {
	private String name;
	private float price;
	private String description;

	public Product() {
	}

	public Product(int id, String name, float price, String description) {
		super(id);
		this.name = name;
		this.price = price;
		this.description = description;
	}

	@Override
	public String toString() {
		return getId()+ " " + name + " " + price + " " + description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
