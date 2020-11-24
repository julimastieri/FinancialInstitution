package com.solvd.OnlineShop.services;

import java.util.Optional;

import com.solvd.OnlineShop.dao.IProductDAO;
import com.solvd.OnlineShop.dao.IUserDAO;
import com.solvd.OnlineShop.dao.mysql.ProductDAO;
import com.solvd.OnlineShop.dao.mysql.UserDAO;
import com.solvd.OnlineShop.models.User;

public class UserService {
	private IUserDAO userDao;
	private IProductDAO productDao;
	private PreferenceService preferenceService;
	private SearchHistoryService searchService;

	public UserService() {
		userDao = new UserDAO();
		productDao = new ProductDAO();
		preferenceService = new PreferenceService();
		searchService = new SearchHistoryService();
	}

	public User getUserById(long id) {
		User user = null;
		Optional<User> userOptional = userDao.getUserById((int)id);

		if (userOptional.isPresent()) {
			user = userOptional.get();
			user.setProducts(productDao.getProductsByUserId(id).get());
			user.setSearchHistory(searchService.getSearchHistoryByUserId(id));
			user.setPreferences(preferenceService.getPreferencesByUserId(id));
		}

		return user;
	}
}
