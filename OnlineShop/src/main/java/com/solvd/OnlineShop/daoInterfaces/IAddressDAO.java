package com.solvd.OnlineShop.daoInterfaces;

import com.solvd.OnlineShop.models.Address;
import java.util.List;

public interface IAddressDAO {
	public Address getShippingAddress(long id);
	public List<Address> getUserAddresses(long id);
}
