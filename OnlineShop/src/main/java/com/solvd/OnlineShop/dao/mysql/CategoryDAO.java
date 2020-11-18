package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.ICategoryDAO;
import com.solvd.OnlineShop.models.Category;

public class CategoryDAO extends MySQLAbstractDAO implements ICategoryDAO {
	private static final Logger logger = Logger.getLogger(CategoryDAO.class);
	private final static String GET_CATEGORY_BY_PREFERENCE = "SELECT * FROM Preferences p LEFT JOIN Categories c ON p.category_id=c.id where p.id=?";

	private Category getAllAtributesFromTable(ResultSet rs) throws SQLException {
		return new Category(rs.getInt("id"), rs.getString("name"));
	}
	
	@Override
	public Optional<Category> getCategoryByPreferenceId(long preferenceId) {
		Category category = null;

		try (Connection con = pool.getConnection();
				PreparedStatement pr = con.prepareStatement(GET_CATEGORY_BY_PREFERENCE);
				ResultSet rs = pr.executeQuery();) {

			pr.setLong(1, preferenceId);
			if (rs.next()) {
				category = getAllAtributesFromTable(rs);
			}

		} catch (InterruptedException | SQLException e) {
			logger.error(e);
		}

		return Optional.ofNullable(category);
	}

	@Override
	public Category save(Category e, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
