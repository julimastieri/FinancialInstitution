package com.solvd.OnlineShop.models;

public abstract class AbstractEntity {
	private long id;

	public AbstractEntity(long id) {
		super();
		this.id = id;
	}
	
	public AbstractEntity() {
		this.id=-1;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
