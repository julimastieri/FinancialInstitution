package com.solvd.OnlineShop.services;

import java.util.List;

import com.solvd.OnlineShop.dao.IAddressDAO;
import com.solvd.OnlineShop.dao.mysql.AddressDAO;
import com.solvd.OnlineShop.models.Address;

public class AddressService {
	IAddressDAO addressDao = new AddressDAO();
	
	public List<Address> getAddressesByUserId(long id) {
		 return addressDao.getAddressesByUserId(id);
	}
}
