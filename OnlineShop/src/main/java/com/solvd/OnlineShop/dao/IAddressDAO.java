package com.solvd.OnlineShop.dao;

import com.solvd.OnlineShop.models.Address;
import java.util.List;
import java.util.Optional;

public interface IAddressDAO extends IBaseDAO<Address>{
	public Optional<Address> getShippingAddress(long id);
	public Optional<List<Address>> getAddressesByUserId(long id);
}
