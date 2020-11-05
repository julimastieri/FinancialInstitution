package com.solvd.OnlineShop.daoInterfaces;

import com.solvd.OnlineShop.models.Order;

public interface IOrderDAO {
	public Order getOrderById(long id);
}
