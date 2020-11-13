package com.solvd.OnlineShop.sax;

import org.apache.log4j.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import com.solvd.OnlineShop.models.Notification;
import com.solvd.OnlineShop.models.User;

import java.io.IOException;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
	private String lastest;
	private String elementValue;
	String xmlFileName;

	public SAXHandler(String xmlFileName) {
		userList = new ArrayList<User>();
		notificationList = new ArrayList<Notification>();
		lastest = null;
		this.xmlFileName = xmlFileName;
	}
	
	public void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(xmlFileName, this);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.error(e);
		}
    }

	@Override
	public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
		switch (qName) {
		case USER:
			userList.add(new User());
			lastest = qName;
			break;
		case NOTIFICATION:
			notificationList.add(new Notification());
			lastest = qName;
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		elementValue = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (lastest) {
		case USER:
			switch (qName) {
			case ID:
				userList.get(userList.size() - 1).setId(Long.parseLong(elementValue));
				break;
			case NAME:
				userList.get(userList.size() - 1).setName(elementValue);
				break;
			case LAST_NAME:
				userList.get(userList.size() - 1).setLastName(elementValue);
				break;
			case AGE:
				userList.get(userList.size() - 1).setAge(Integer.parseInt(elementValue));
				break;
			case EMAIL:
				userList.get(userList.size() - 1).setEmail(elementValue);
				break;
			case PASSWORD:
				userList.get(userList.size() - 1).setPassword(elementValue);
				break;
			case MOBILE:
				userList.get(userList.size() - 1).setMobile(elementValue);
				break;
			}
			break;
		case NOTIFICATION:
			logger.info("elementValue: " + elementValue);
			switch (qName) {
			case ID:
				notificationList.get(notificationList.size() - 1).setId(Long.parseLong(elementValue));
				break;
			case TITLE:
				notificationList.get(notificationList.size() - 1).setTitle(elementValue);
				break;
			case DESCRIPTION:
				notificationList.get(notificationList.size() - 1).setDescription(elementValue);
				break;
			case READED:
				notificationList.get(notificationList.size() - 1).setReaded(Boolean.parseBoolean(elementValue));
				break;
			case USER_ID:
				notificationList.get(notificationList.size() - 1).setUser(getUserById(Long.parseLong(elementValue)));
				break;
			}
			break;
		}
	}
	
	public User getUserById(long userId) {
		return userList.stream().filter(u -> userId == u.getId()).findFirst().get();
	}

	public List<User> getUserList() {
		return userList;
	}

	public List<Notification> getNotificationList() {
		return notificationList;
	}

}
