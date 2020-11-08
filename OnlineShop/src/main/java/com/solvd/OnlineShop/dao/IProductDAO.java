package com.solvd.OnlineShop.dao;

import java.util.List;

import com.solvd.OnlineShop.models.Product;

public interface IProductDAO {
	public List<Product> getProductsByUserId(long userId);
}
