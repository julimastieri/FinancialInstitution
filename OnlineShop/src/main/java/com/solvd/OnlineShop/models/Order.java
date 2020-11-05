package com.solvd.OnlineShop.models;

public class Order {
	private int id;
	private float total;
	private float discount;
	private Address shippingAddress;
	
	public Order() {
	}
	
	public Order(int id, float total, float discount) {
		super();
		this.id = id;
		this.total = total;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	
}
