package com.solvd.OnlineShop.dao;

import com.solvd.OnlineShop.models.Order;

public interface IOrderDAO extends IBaseDAO<Order> {
	public Order getOrderById(long id);
}
