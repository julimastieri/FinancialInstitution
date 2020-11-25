package com.solvd.OnlineShop.dao.mybatis;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.solvd.OnlineShop.models.Order;

public interface IOrderDAO extends IBaseDAO<Order> {
	@Select("SELECT * FROM Orders o LEFT JOIN Addresses a ON o.shipping_address = a.id WHERE o.id=#{id}")
	@ResultMap("OrderResultMap")
	public Order getOrderById(long id);
}
