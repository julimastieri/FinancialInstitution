package com.solvd.OnlineShop.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends AbstractEntity {

	private String name;
	@XmlElement(name = "last_name")
	@JsonProperty("last_name")
	private String lastName;
	private int age;
	private String email;
	private String password;
	private String mobile;
	
	@XmlElementWrapper(name="products")
	@XmlElement(name="product")
	private List<Product> products;
	
	@XmlElementWrapper(name="search_histories")
	@XmlElement(name="search_history")
	private List<SearchHistory> searchHistory;
	
	@XmlElementWrapper(name="preferences")
	@XmlElement(name="preference")
	private List<Preference> preferences;

	public User() {
	}

	public User(long id, String name, String lastName, int age, String email, String password, String mobile) {
		super(id);
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.products = new ArrayList<Product>();
		this.searchHistory = new ArrayList<SearchHistory>();
		this.preferences = new ArrayList<Preference>();
	}

	@Override
	public String toString() {
		return getId() + " " + name + " " + lastName + " " + age + " " + email + " " + password + " " + mobile;
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
	
	public void addProduct(Product p) {
		this.products.add(p);
	}

	public List<SearchHistory> getSearchHistory() {
		return searchHistory;
	}

	public void setSearchHistory(List<SearchHistory> searchHistory) {
		this.searchHistory = searchHistory;
	}
	
	public void addSearchHistory(SearchHistory sh) {
		this.searchHistory.add(sh);
	}
	
	public List<Preference> getPreferences() {
		return preferences;
	}
	
	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}
	
	public void addPreference(Preference p) {
		this.preferences.add(p);
	}

}
