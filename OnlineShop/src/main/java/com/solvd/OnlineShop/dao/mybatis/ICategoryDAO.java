package com.solvd.OnlineShop.dao.mybatis;


import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.solvd.OnlineShop.models.Category;

public interface ICategoryDAO extends IBaseDAO<Category>{
	@Select("SELECT * FROM Preferences p LEFT JOIN Categories c ON p.category_id=c.id where p.id=#{id}")
	@ResultMap("CategoryResultMap")
	public Category getCategoryByPreferenceId(long preferenceId);
}
