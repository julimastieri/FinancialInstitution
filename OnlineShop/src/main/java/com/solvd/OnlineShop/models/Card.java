package com.solvd.OnlineShop.models;

import java.sql.Date;

public class Card extends AbstractEntity{
	private int cardVerificationValue;
	private String bank;
	private int number;
	private String cardholderName;
	private Date expirationDate;
	private User user;
	
	public Card() {
	}

	public Card(long id, int cardVerificationValue, String bank, int number, String cardholderName, Date expirationDate,
			User user) {
		super(id);
		this.cardVerificationValue = cardVerificationValue;
		this.bank = bank;
		this.number = number;
		this.cardholderName = cardholderName;
		this.expirationDate = expirationDate;
		this.user = user;
	}

	public int getCardVerificationValue() {
		return cardVerificationValue;
	}

	public void setCardVerificationValue(int cardVerificationValue) {
		this.cardVerificationValue = cardVerificationValue;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
