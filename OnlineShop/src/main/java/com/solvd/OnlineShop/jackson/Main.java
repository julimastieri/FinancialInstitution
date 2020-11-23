package com.solvd.OnlineShop.jackson;

import java.util.Date;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.OnlineShop.models.Category;
import com.solvd.OnlineShop.models.Notification;
import com.solvd.OnlineShop.models.Preference;
import com.solvd.OnlineShop.models.Product;
import com.solvd.OnlineShop.models.SearchHistory;
import com.solvd.OnlineShop.models.User;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		jsonMapper();
		
	}
	
	public static void jsonMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		
		Product product = new Product(1, "Pc", 1000, "A computer");
		SearchHistory sh = new SearchHistory(1, new Date());
		sh.setProduct(product);

		Category cat = new Category(1, "Technology");

		Preference pre = new Preference(1);
		pre.setCategory(cat);

		User user = new User(1, "julian", "mastieri", 22, "jm@mail.com", "pass", "mob");
		user.addProduct(product);
		user.addSearchHistory(sh);
		user.addPreference(pre);

		Notification notification = new Notification(1, "New purchase order completed", "You buy a notebook", true,
				user);

		try {
			String json = objectMapper.writeValueAsString(notification);
			Notification noti = objectMapper.readValue(json, Notification.class);	
		} catch (JsonProcessingException e) {
			logger.error(e);
		}
	}
}
