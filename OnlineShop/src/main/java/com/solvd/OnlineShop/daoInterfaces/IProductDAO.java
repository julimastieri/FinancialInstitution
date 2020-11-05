package com.solvd.OnlineShop.daoInterfaces;

import java.util.List;

import com.solvd.OnlineShop.models.Product;

public interface IProductDAO {
	public List<Product> getProductsByUserId(long userId);
}
