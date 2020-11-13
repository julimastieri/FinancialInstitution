package com.solvd.OnlineShop.sax;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.solvd.OnlineShop.models.User;


public class Main {
	private static final Logger logger = Logger.getLogger(Main.class);
	
	
	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			SAXHandler saxHandler = new SAXHandler();
			saxParser.parse("./src/main/resources/onlineshopData.xml", saxHandler);
			
			List<User> userList = saxHandler.getUserList();
			logger.info(userList.size());
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.error(e);
		}
		
		
	}

}
