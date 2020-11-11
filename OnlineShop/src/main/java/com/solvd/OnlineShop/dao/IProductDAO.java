package com.solvd.OnlineShop.dao;

import java.util.List;
import java.util.Optional;

import com.solvd.OnlineShop.models.Product;

public interface IProductDAO extends IBaseDAO<Product> {
	public Optional<List<Product>> getProductsByUserId(long userId);
	public Optional<Product> getProductsBySearchId(long searchId);
}
