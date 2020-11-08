package com.solvd.OnlineShop;

import com.solvd.OnlineShop.dao.*;
import com.solvd.OnlineShop.dao.mysql.AddressDAO;
import com.solvd.OnlineShop.dao.mysql.OrderDAO;
import com.solvd.OnlineShop.dao.mysql.ProductDAO;
import com.solvd.OnlineShop.dao.mysql.UserDAO;
import com.solvd.OnlineShop.models.*;

public class Main {
	public static void main(String[] args) {

		//setProductsToUser(1);
		//setAddressToOrder(3);
		getUserAddresses(2);

	}

	public static void setProductsToUser(long id) {
		IUserDAO ud = new UserDAO();
		User u = ud.getUserById(id);
		
		ProductDAO pd = new ProductDAO();
		u.setProducts(pd.getProductsByUserId(id));
	}
	
	public static void setAddressToOrder(long id) {
		IOrderDAO od = new OrderDAO();
		Order o = od.getOrderById(id);
		
		AddressDAO ad = new AddressDAO();
		o.setShippingAddress(ad.getShippingAddress(id));
	}
	
	public static void getUserAddresses(long id) {
		IAddressDAO ad = new AddressDAO();
		ad.getUserAddresses(id);
	}

}