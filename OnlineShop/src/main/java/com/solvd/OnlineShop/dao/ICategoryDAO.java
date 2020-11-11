package com.solvd.OnlineShop.dao;

import java.util.Optional;

import com.solvd.OnlineShop.models.Category;

public interface ICategoryDAO extends IBaseDAO<Category>{
	public Optional<Category> getCategoryByPreferenceId(long preferenceId);
}
