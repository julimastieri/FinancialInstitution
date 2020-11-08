package com.solvd.OnlineShop.models;

public class Transaction extends AbstractEntity{
	private String paymentMethod;
	private String status;
	private Order order;
	
	public Transaction() {
	}
	
	public Transaction(long id, String paymentMethod, String status, Order order) {
		super(id);
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.order = order;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
