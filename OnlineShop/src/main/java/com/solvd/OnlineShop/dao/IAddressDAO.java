package com.solvd.OnlineShop.dao;

import com.solvd.OnlineShop.models.Address;
import java.util.List;

public interface IAddressDAO extends IBaseDAO<Address>{
	public Address getShippingAddress(long id);
	public List<Address> getAddressesByUserId(long id);
}
