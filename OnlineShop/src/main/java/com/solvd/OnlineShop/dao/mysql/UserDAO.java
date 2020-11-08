package com.solvd.OnlineShop.dao.mysql;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IUserDAO;
import com.solvd.OnlineShop.models.User;

public class UserDAO extends MySQLAbstractDAO implements IUserDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class);
	private final static String GET_USER = "SELECT * FROM Users u where u.id=?";
	private static final String INSERT = "INSERT INTO Users(name, last_name, age, email, password, mobile) VALUES(?,?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM Users WHERE id = ?";

	public User getUserById(long id) {

		User u = null;

		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(GET_USER);
			pr.setLong(1, id);
			rs = pr.executeQuery();

			if (rs.next()) {
				u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getInt("age"),
						rs.getString("email"), rs.getString("password"), rs.getString("mobile"));
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

	@Override
	public User save(User e, long id) {
		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(INSERT);

			pr.setString(1, e.getName());
			pr.setString(2, e.getLastName());
			pr.setInt(3, e.getAge());
			pr.setString(4, e.getEmail());
			pr.setString(5, e.getPassword());
			pr.setString(6, e.getMobile());
			if (pr.executeUpdate() == 0) {
				logger.error("It has not been saved correctly");
			}

			return e;
		} catch (SQLException | InterruptedException ex) {
			logger.error(ex);
			return null;
		} finally {
			try {
				pr.close();
			} catch (SQLException ex) {
				logger.error(ex);
			}

			try {
				pool.releaseConnection(con);
			} catch (InterruptedException exe) {
				logger.error(exe);
			}
		}
	}

	@Override
	public boolean removeById(long id) {
		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(DELETE);
			pr.setLong(1, id);
			pr.executeUpdate();
			return true;
		} catch (SQLException | InterruptedException ex) {
			logger.error(ex);
			return false;
		} finally {
			try {
				pr.close();
			} catch (SQLException ex) {
				logger.error(ex);
			}

			try {
				pool.releaseConnection(con);
			} catch (InterruptedException e) {
				logger.error(e);
			}
		}
	}
}
