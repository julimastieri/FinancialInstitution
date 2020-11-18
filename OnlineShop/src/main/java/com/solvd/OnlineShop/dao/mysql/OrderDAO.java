package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IOrderDAO;
import com.solvd.OnlineShop.models.Order;

public class OrderDAO extends MySQLAbstractDAO implements IOrderDAO {

	private static final Logger logger = Logger.getLogger(ProductDAO.class);
	private final static String GET_ORDER = "SELECT * FROM Orders o where o.id=?";
	
	private Order getAllAtributesFromTable(ResultSet rs) throws SQLException {
		return new Order(rs.getInt("id"), rs.getFloat("total"), rs.getFloat("discount"));
	}

	public Optional<Order> getOrderById(long id) {

		Order o = null;

		try (Connection con = pool.getConnection();
				PreparedStatement pr = con.prepareStatement(GET_ORDER);
				ResultSet rs = pr.executeQuery();) {

			pr.setLong(1, id);
			if (rs.next()) {
				o = getAllAtributesFromTable(rs);
			}

		} catch (InterruptedException | SQLException e) {
			logger.error(e);
		}
		return Optional.ofNullable(o);
	}

	@Override
	public Order save(Order e, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
