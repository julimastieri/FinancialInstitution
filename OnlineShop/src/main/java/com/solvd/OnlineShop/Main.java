package com.solvd.OnlineShop;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.models.*;
import com.solvd.OnlineShop.services.*;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		try {
			//marshal();
			Notification not = unmarshall();
		} catch (JAXBException | IOException e) {
			logger.error(e);
		}
	}
	
	public static Notification unmarshall() throws JAXBException, IOException {
	    JAXBContext context = JAXBContext.newInstance(Notification.class);
	    return (Notification) context.createUnmarshaller()
	      .unmarshal(new FileReader("./src/main/resources/onlineshopData.xml"));
	    //"./src/main/resources/onlineshopData.xml"
	}
	
	public static void marshal() throws JAXBException, IOException {
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
	    
	    Notification notification = new Notification(1, "New purchase order completed", "You buy a notebook", true, user);
	    
	    JAXBContext context = JAXBContext.newInstance(notification.getClass());
	    Marshaller mar= context.createMarshaller();
	    
	    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    mar.marshal(notification, new File("./user.xml"));
	}

	public static void callServices() {
		UserService userService = new UserService();
		User user = userService.getUserById(1);

		OrderService orderService = new OrderService();
		Order order = orderService.getOrderById(3).orElse(new Order());

		AddressService addressService = new AddressService();
		List<Address> addressList = addressService.getAddressesByUserId(1);

	}

}