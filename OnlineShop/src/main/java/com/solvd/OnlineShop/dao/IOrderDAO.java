package com.solvd.OnlineShop.dao;

import com.solvd.OnlineShop.models.Order;

public interface IOrderDAO {
	public Order getOrderById(long id);
}
