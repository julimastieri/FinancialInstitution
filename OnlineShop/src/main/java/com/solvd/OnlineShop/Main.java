package com.solvd.OnlineShop;

import java.util.List;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.models.*;
import com.solvd.OnlineShop.services.*;


public class Main {
	private static final Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		
		UserService userService = new UserService();
		User user = userService.getUserById(1);
		
		OrderService orderService = new OrderService();
		Order order = orderService.getOrderById(3).orElse(new Order());
		
		AddressService addressService = new AddressService();
		List<Address> addressList = addressService.getAddressesByUserId(1);
		
		
	

	}

}