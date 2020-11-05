package com.solvd.OnlineShop;

import org.apache.log4j.PropertyConfigurator;

import com.solvd.OnlineShop.daos.*;
import com.solvd.OnlineShop.models.*;

public class Main {
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");

		//setProductsToUser(1);
		//setAddressToOrder(3);
		getUserAddresses(2);

	}

	public static void setProductsToUser(long id) {
		UserDAO ud = new UserDAO();
		User u = ud.getUserById(id);
		
		ProductDAO pd = new ProductDAO();
		u.setProducts(pd.getProductsByUserId(id));
	}
	
	public static void setAddressToOrder(long id) {
		OrderDAO od = new OrderDAO();
		Order o = od.getOrderById(id);
		
		AddressDAO ad = new AddressDAO();
		o.setShippingAddress(ad.getShippingAddress(id));
	}
	
	public static void getUserAddresses(long id) {
		AddressDAO ad = new AddressDAO();
		ad.getUserAddresses(id);
	}
}