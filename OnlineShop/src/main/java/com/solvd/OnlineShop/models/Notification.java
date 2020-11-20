package com.solvd.OnlineShop.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Notification extends AbstractEntity{
	private String title;
	private String description;
	private Boolean readed;
	private User user;
	
	public Notification() {
	}

	public Notification(long id, String title, String description, Boolean readed, User user) {
		super(id);
		this.title = title;
		this.description = description;
		this.readed = readed;
		this.user = user;
	}
	
	@Override
	public String toString() {
		return getId() + " " + title + " " + description + " " + readed + " " + user.toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getReaded() {
		return readed;
	}

	public void setReaded(Boolean readed) {
		this.readed = readed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
