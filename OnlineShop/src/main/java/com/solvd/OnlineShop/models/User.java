package com.solvd.OnlineShop.models;

import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity{

	private String name;
	private String lastName;
	private int age;
	private String email;
	private String password;
	private String mobile;
	private List<Product> products;
	private List<SearchHistory> searchHistory;
	private List<Preference> preferences;

	public User() {}

	public User(int id, String name, String lastName, int age, String email, String password, String mobile) {
		super(id);
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.products = new ArrayList<Product>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<SearchHistory> getSearchHistory() {
		return searchHistory;
	}

	public void setSearchHistory(List<SearchHistory> searchHistory) {
		this.searchHistory = searchHistory;
	}

	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}

}
