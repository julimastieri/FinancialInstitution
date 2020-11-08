package com.solvd.OnlineShop.services;

import com.solvd.OnlineShop.dao.IAddressDAO;
import com.solvd.OnlineShop.dao.IOrderDAO;
import com.solvd.OnlineShop.dao.mysql.AddressDAO;
import com.solvd.OnlineShop.dao.mysql.OrderDAO;
import com.solvd.OnlineShop.models.Order;

public class OrderService {
	private IOrderDAO orderDao = new OrderDAO();
	IAddressDAO addressDao = new AddressDAO();
	
	public Order getOrderById(long id) {
		Order order = orderDao.getOrderById(id);
		order.setShippingAddress(addressDao.getShippingAddress(id));
		
		return order;
	}

}
