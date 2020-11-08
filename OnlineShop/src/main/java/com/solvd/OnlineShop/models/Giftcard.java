package com.solvd.OnlineShop.models;

public class Giftcard extends AbstractEntity{
	private float amount;
	private User user;
	private String code;
	
	public Giftcard() {
	}

	public Giftcard(long id, float amount, User user, String code) {
		super(id);
		this.amount = amount;
		this.user = user;
		this.code = code;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
