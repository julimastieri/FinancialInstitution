package com.solvd.OnlineShop.dao;

import java.util.Optional;

import com.solvd.OnlineShop.models.Order;

public interface IOrderDAO extends IBaseDAO<Order> {
	public Optional<Order> getOrderById(long id);
}
