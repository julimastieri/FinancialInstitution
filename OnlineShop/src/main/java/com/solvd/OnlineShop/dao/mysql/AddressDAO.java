package com.solvd.OnlineShop.dao.mysql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IAddressDAO;
import com.solvd.OnlineShop.models.Address;

public class AddressDAO extends MySQLAbstractDAO implements IAddressDAO {
	private static final Logger logger = Logger.getLogger(AddressDAO.class);
	private final static String GET_SHIPPING_ADDRESS = "SELECT * FROM Orders o LEFT JOIN Addresses a ON o.shipping_address = a.id WHERE o.id=?";
	private final static String GET_USER_ADDRESSES = "SELECT DISTINCT a.* FROM Addresses a LEFT JOIN Orders o ON o.shipping_address = a.id WHERE o.buyer_id=?";

	public Address getShippingAddress(long id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}

		Address a = null;
		
		try {
			con = pool.getAConnection();
			this.pr = con.prepareStatement(GET_SHIPPING_ADDRESS);
			pr.setLong(1, id);
			rs = pr.executeQuery();

			if (rs.next()) {
				a = new Address(rs.getInt("id"), rs.getInt("number"), rs.getString("street"), rs.getString("city"),
						rs.getString("province"), rs.getString("country"));
			}

		} catch (InterruptedException e) {
			logger.error(e);
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error(e);
			}
			try {
				pr.close();
			} catch (SQLException e) {
				logger.error(e);
			}
			try {
				pool.releaseConnection(con);
			} catch (InterruptedException e) {
				logger.error(e);
			}
		}
		return a;
	}

	public List<Address> getUserAddresses(long id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}

		List<Address> al = new ArrayList<Address>();

		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(GET_USER_ADDRESSES);
			pr.setLong(1, id);
			rs = pr.executeQuery();

			while (rs.next()) {
				al.add(new Address(rs.getInt("id"), rs.getInt("number"), rs.getString("street"), rs.getString("city"),
						rs.getString("province"), rs.getString("country")));
			}

		} catch (InterruptedException e) {
			logger.error(e);
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error(e);
			}
			try {
				pr.close();
			} catch (SQLException e) {
				logger.error(e);
			}
			try {
				pool.releaseConnection(con);
			} catch (InterruptedException e) {
				logger.error(e);
			}
		}
		return al;
	}
}
