package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IUserDAO;
import com.solvd.OnlineShop.models.User;

public class UserDAO extends MySQLAbstractDAO implements IUserDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class);
	private final static String GET_USER = "SELECT * FROM Users u where u.id=?";

	public User getUserById(long id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}

		User u = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;

		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(GET_USER);
			pr.setLong(1, id);
			rs = pr.executeQuery();

			if (rs.next()) {
				u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("email"), rs.getString("password"), rs.getString("mobile"));
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

		return u;

	}
}
