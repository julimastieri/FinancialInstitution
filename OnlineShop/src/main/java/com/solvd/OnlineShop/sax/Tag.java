package com.solvd.OnlineShop.sax;

public enum Tag {
	USER("user"),
	NOTIFICATION("notification"),
	ID("id"),
	NAME("name"),
	LAST_NAME("last_name"),
	AGE("age"),
	EMAIL("email"),
	PASSWORD("password"),
	MOBILE("mobile"),
	TITLE("title"),
	DESCRIPTION("description"),
	READED("readed"),
	USER_ID("user_id"),
	;

	private String tag;
	
	Tag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

}