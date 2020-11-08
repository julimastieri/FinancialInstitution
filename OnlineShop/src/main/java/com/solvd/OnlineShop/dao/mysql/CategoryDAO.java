package com.solvd.OnlineShop.dao.mysql;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.ICategoryDAO;
import com.solvd.OnlineShop.models.Category;

public class CategoryDAO extends MySQLAbstractDAO implements ICategoryDAO {
	private static final Logger logger = Logger.getLogger(CategoryDAO.class);
	private final static String GET_CATEGORY_BY_PREFERENCE = "SELECT * FROM Preferences p LEFT JOIN Categories c ON p.category_id=c.id where p.id=?";
	
	@Override
	public Category getCategoryByPreferenceId(long preferenceId) {
		Category category = null;

		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(GET_CATEGORY_BY_PREFERENCE);
			pr.setLong(1, preferenceId);
			rs = pr.executeQuery();

			if (rs.next()) {
				category = new Category(rs.getInt("id"), rs.getString("name"));
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
		return category;
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
