package com.solvd.OnlineShop;

import java.util.List;

import com.solvd.OnlineShop.models.*;
import com.solvd.OnlineShop.services.*;


public class Main {
	
	public static void main(String[] args) {
		
		UserService userService = new UserService();
		User user = userService.getUserById(1);
		
		OrderService orderService = new OrderService();
		Order order = orderService.getOrderById(3);
		
		AddressService addressService = new AddressService();
		List<Address> addressList = addressService.getAddressesByUserId(1);
	

	}

}