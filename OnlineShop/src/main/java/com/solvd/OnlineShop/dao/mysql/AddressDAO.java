package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IAddressDAO;
import com.solvd.OnlineShop.models.Address;

public class AddressDAO extends MySQLAbstractDAO implements IAddressDAO {
	private static final Logger logger = Logger.getLogger(AddressDAO.class);
	private final static String GET_SHIPPING_ADDRESS = "SELECT * FROM Orders o LEFT JOIN Addresses a ON o.shipping_address = a.id WHERE o.id=?";
	private final static String GET_USER_ADDRESSES = "SELECT DISTINCT a.* FROM Addresses a LEFT JOIN Orders o ON o.shipping_address = a.id WHERE o.buyer_id=?";

	private Address getAllAtributesFromTable(ResultSet rs) throws SQLException {
		return new Address(rs.getInt("id"), rs.getInt("number"), rs.getString("street"),
				rs.getString("city"), rs.getString("province"), rs.getString("country"));
	}
	
	public Optional<Address> getShippingAddress(long id) {
		Address address = null;

		try (Connection con = pool.getConnection();
				PreparedStatement pr = con.prepareStatement(GET_SHIPPING_ADDRESS);
				ResultSet rs = pr.executeQuery();) {

			pr.setLong(1, id);
			if (rs.next()) {
				address = getAllAtributesFromTable(rs);
			}

		} catch (InterruptedException | SQLException e) {
			logger.error(e);
		}

		return Optional.ofNullable(address);
	}

	public Optional<List<Address>> getAddressesByUserId(long id) {
		List<Address> al = new ArrayList<Address>();

		try (Connection con = pool.getConnection();
				PreparedStatement pr = con.prepareStatement(GET_USER_ADDRESSES);
				ResultSet rs = pr.executeQuery();) {

			pr.setLong(1, id);
			while (rs.next()) {
				al.add(getAllAtributesFromTable(rs));
			}

		} catch (InterruptedException | SQLException e) {
			logger.error(e);
		}

		return Optional.of(al);
	}

	@Override
	public Address save(Address e, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
