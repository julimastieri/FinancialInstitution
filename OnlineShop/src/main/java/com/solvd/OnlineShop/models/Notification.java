package com.solvd.OnlineShop.models;

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
