package com.solvd.OnlineShop.dao;

import java.util.List;

import com.solvd.OnlineShop.models.Product;

public interface IProductDAO extends IBaseDAO<Product> {
	public List<Product> getProductsByUserId(long userId);
	public Product getProductsBySearchId(long searchId);
}
