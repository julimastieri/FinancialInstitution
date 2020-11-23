package com.solvd.OnlineShop.dao;


import java.util.Optional;

import org.apache.ibatis.annotations.Select;

import com.solvd.OnlineShop.models.User;

public interface IUserDAO extends IBaseDAO<User>{
	@Select("Select * FROM Users u  WHERE u.id = #{id}")//LEFT JOIN Products p ON u.id=p.user_id
	public Optional<User> getUserById(int id);
}
