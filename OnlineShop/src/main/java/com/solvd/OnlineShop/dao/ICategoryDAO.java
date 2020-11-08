package com.solvd.OnlineShop.dao;

import com.solvd.OnlineShop.models.Category;

public interface ICategoryDAO extends IBaseDAO<Category>{
	public Category getCategoryByPreferenceId(long preferenceId);
}
