package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IUserDAO;
import com.solvd.OnlineShop.models.User;

public class UserDAO extends MySQLAbstractDAO implements IUserDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class);
	private final static String GET_USER = "SELECT * FROM Users u where u.id=?";
	private static final String INSERT = "INSERT INTO Users(name, last_name, age, email, password, mobile) VALUES(?,?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM Users WHERE id = ?";
	
	private User getAllAtributesFromTable(ResultSet rs) throws SQLException {
		return new User(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getInt("age"),
				rs.getString("email"), rs.getString("password"), rs.getString("mobile"));
	}

	public Optional<User> getUserById(long id) {

		User u = null;

		try (Connection con = pool.getConnection();
				PreparedStatement pr = con.prepareStatement(GET_USER);
				ResultSet rs = pr.executeQuery();) {

			pr.setLong(1, id);
			if (rs.next()) {
				u = getAllAtributesFromTable(rs);
			}

		} catch (InterruptedException | SQLException e) {
			logger.error(e);
		}

		return Optional.ofNullable(u);
	}

	@Override
	public User save(User e, long id) {
		try (Connection con = pool.getConnection(); PreparedStatement pr = con.prepareStatement(INSERT);) {

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
		} catch (InterruptedException | SQLException ex) {
			logger.error(ex);
		}
		return e;
	}

	@Override
	public boolean removeById(long id) {
		try (Connection con = pool.getConnection(); PreparedStatement pr = con.prepareStatement(DELETE);){
			
			pr.setLong(1, id);
			pr.executeUpdate();
			return true;
		} catch (SQLException | InterruptedException ex) {
			logger.error(ex);
			return false;
		} 
	}
}
