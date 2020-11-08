package com.solvd.OnlineShop.dao;


import com.solvd.OnlineShop.models.User;

public interface IUserDAO extends IBaseDAO<User>{
	public User getUserById(long id);
}
