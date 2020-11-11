package com.solvd.OnlineShop.dao;


import java.util.Optional;

import com.solvd.OnlineShop.models.User;

public interface IUserDAO extends IBaseDAO<User>{
	public Optional<User> getUserById(long id);
}
