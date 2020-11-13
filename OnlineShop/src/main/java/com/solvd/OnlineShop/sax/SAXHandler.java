package com.solvd.OnlineShop.sax;

import org.apache.log4j.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import com.solvd.OnlineShop.models.AbstractEntity;
import com.solvd.OnlineShop.models.Notification;
import com.solvd.OnlineShop.models.User;

import java.util.*;
import java.io.*;

public class SAXHandler extends DefaultHandler {
	private static final Logger logger = Logger.getLogger(SAXHandler.class);

	private static final String USER = "user";
	private static final String NOTIFICATION = "notification";

	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String LAST_NAME = "last_name";
	private static final String AGE = "age";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String MOBILE = "mobile";
	private static final String TITLE = "title";
	private static final String DESCRIPTION = "description";
	private static final String READED = "readed";
	private static final String USER_ID = "user_id";

	private List<User> userList;
	private List<Notification> notificationList;
	private AbstractEntity lastest;
	private String elementValue;

	public SAXHandler() {
		userList = new ArrayList<User>();
		notificationList = new ArrayList<Notification>();
		lastest = null;
	}

	@Override
	public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
		switch (qName) {
		case USER:
			userList.add(new User());
			lastest = userList.get(userList.size() - 1);
			break;
		case NOTIFICATION:
			notificationList.add(new Notification());
			lastest = userList.get(notificationList.size() - 1);
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		elementValue = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case ID:
			lastest.setId(Long.parseLong(elementValue));
			break;
		case NAME:
			((User) lastest).setName(elementValue); // i have to add a cast here but this is wrong
			break;
		}
	}

	public List<User> getUserList() {
		return userList;
	}

	public List<Notification> getNotificationList() {
		return notificationList;
	}

}
