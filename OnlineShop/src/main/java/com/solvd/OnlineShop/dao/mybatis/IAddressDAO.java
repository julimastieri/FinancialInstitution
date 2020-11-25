package com.solvd.OnlineShop.dao.mybatis;

import com.solvd.OnlineShop.models.Address;
import java.util.Optional;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface IAddressDAO extends IBaseDAO<Address>{
	
	@Select("SELECT * FROM Orders o LEFT JOIN Addresses a ON o.shipping_address = a.id WHERE o.id=#{id}")
	@ResultMap("AddressResultMap")
	public Optional<Address> getShippingAddress(long id);

}
