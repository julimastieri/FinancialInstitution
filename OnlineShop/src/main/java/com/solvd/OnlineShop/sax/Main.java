package com.solvd.OnlineShop.sax;

import org.apache.log4j.Logger;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		SAXHandler saxHandler = new SAXHandler("./src/main/resources/onlineshopData.xml");
		saxHandler.parseDocument();
		saxHandler.getUserList().stream().forEach(u -> logger.info(u.toString()));
		saxHandler.getNotificationList().stream().forEach(n -> logger.info(n.toString()));
	}

}
