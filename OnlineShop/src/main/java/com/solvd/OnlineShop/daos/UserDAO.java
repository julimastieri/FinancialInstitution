package com.solvd.OnlineShop.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.daoInterfaces.IUserDAO;
import com.solvd.OnlineShop.models.User;
import com.solvd.OnlineShop.mySqlAbstractDAO.MySQLAbstractDAO;

public class UserDAO extends MySQLAbstractDAO implements IUserDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class);
	private final static String GET_USER = "SELECT * FROM users u where u.id=?";

	public User getUserById(long id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}

		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;

		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(GET_USER);
			pr.setLong(1, id);
			rs = pr.executeQuery();
			System.out.println(rs.getString("name"));
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

		return null;

	}
}
