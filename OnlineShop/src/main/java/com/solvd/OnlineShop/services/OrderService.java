package com.solvd.OnlineShop.services;

import java.util.Optional;

import com.solvd.OnlineShop.dao.IAddressDAO;
import com.solvd.OnlineShop.dao.IOrderDAO;
import com.solvd.OnlineShop.dao.mysql.AddressDAO;
import com.solvd.OnlineShop.dao.mysql.OrderDAO;
import com.solvd.OnlineShop.models.Order;

public class OrderService {
	private IOrderDAO orderDao;
	private IAddressDAO addressDao;

	public OrderService() {
		orderDao = new OrderDAO();
		addressDao = new AddressDAO();
	}

	public Optional<Order> getOrderById(long id) {
		Order order = null;
		Optional<Order> optionalOrder = orderDao.getOrderById(id);
		if (optionalOrder.isPresent()) {
			order = orderDao.getOrderById(id).get();
			order.setShippingAddress(addressDao.getShippingAddress(id).get());
		}

		return Optional.ofNullable(order);
	}

}
