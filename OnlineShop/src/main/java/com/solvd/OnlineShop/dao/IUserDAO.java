package com.solvd.OnlineShop.dao;


import java.util.Optional;

import org.apache.ibatis.annotations.Select;

import com.solvd.OnlineShop.models.User;

public interface IUserDAO extends IBaseDAO<User>{
	@Select("SELECT * FROM Users u WHERE id = #{id}")
	public Optional<User> getUserById(int id);
}
