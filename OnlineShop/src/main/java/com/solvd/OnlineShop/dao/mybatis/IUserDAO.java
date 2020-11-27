package com.solvd.OnlineShop.dao.mybatis;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.solvd.OnlineShop.models.User;

public interface IUserDAO extends IBaseDAO<User>{
	
	@Select("Select u.*, prod.name as prod_name, prod.price as prod_price, prod.description as prod_description, prod.id as prod_id, prod.user_id as prod_user_id FROM Users u LEFT JOIN Products prod ON u.id = prod.user_id "
			+ "LEFT JOIN Search_Histories sh ON sh.user_id=u.id "
			+ "LEFT JOIN Preferences pref ON pref.user_id=u.id "
			+ "WHERE u.id = #{id}")
	@ResultMap("UserResultMap")
	public User getUserById(int id);
	
}
