package com.solvd.OnlineShop.dao.mybatis;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.solvd.OnlineShop.models.Product;

public interface IProductDAO extends IBaseDAO<Product> {
	
	@Select("SELECT * FROM Search_Histories sh LEFT JOIN Products p ON sh.product_id=p.id where sh.id=#{id}")
	@ResultMap("ProductResultMap")
	public Product getProductsBySearchId(long searchId);
	
}
