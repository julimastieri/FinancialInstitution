package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IProductDAO;
import com.solvd.OnlineShop.models.Product;

public class ProductDAO extends MySQLAbstractDAO implements IProductDAO {
	private static final Logger logger = Logger.getLogger(ProductDAO.class);
	private final static String GET_USER_PRODUCTS = "SELECT * FROM Products p where p.user_id=?";

	public List<Product> getProductsByUserId(long userId) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}

		List<Product> lp = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;

		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(GET_USER_PRODUCTS);
			pr.setLong(1, userId);
			rs = pr.executeQuery();

			while (rs.next()) {
				lp.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"), rs.getString("description")));
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
		return lp;
	}
}
