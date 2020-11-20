package com.solvd.OnlineShop.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address extends AbstractEntity{
	private float number;
	private String street;
	private String city;
	private String province;
	private String country;
	
	public Address() {
	}
	
	public Address(int id, float number, String street, String city, String province, String country) {
		super(id);
		this.number = number;
		this.street = street;
		this.city = city;
		this.province = province;
		this.country = country;
	}

	public float getNumber() {
		return number;
	}

	public void setNumber(float number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
