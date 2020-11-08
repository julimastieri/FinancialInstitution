package com.solvd.OnlineShop.services;

import com.solvd.OnlineShop.dao.IProductDAO;
import com.solvd.OnlineShop.dao.IUserDAO;
import com.solvd.OnlineShop.dao.mysql.ProductDAO;
import com.solvd.OnlineShop.dao.mysql.UserDAO;
import com.solvd.OnlineShop.models.User;

public class UserService {
	IUserDAO userDao = new UserDAO();
	IProductDAO productDao = new ProductDAO();
	PreferenceService preferenceService = new PreferenceService();
	SearchHistoryService searchService = new SearchHistoryService();
	
	
	public User getUserById(long id) {
		User user = userDao.getUserById(id);
		user.setProducts(productDao.getProductsByUserId(id));
		user.setSearchHistory(searchService.getSearchHistoryByUserId(id));
		user.setPreferences(preferenceService.getPreferencesByUserId(id));
		return user;
	}
}
