package com.solvd.OnlineShop.dao.mysql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IProductDAO;
import com.solvd.OnlineShop.models.Product;

public class ProductDAO extends MySQLAbstractDAO implements IProductDAO {
	private static final Logger logger = Logger.getLogger(ProductDAO.class);
	private final static String GET_USER_PRODUCTS_BY_USER_ID = "SELECT * FROM Products p where p.user_id=?";
	private final static String GET_USER_PRODUCTS_BY_SEARCH_ID = "SELECT * FROM Search_Histories sh LEFT JOIN Products p ON sh.product_id=p.id where sh.id=?";

	public List<Product> getProductsByUserId (long userId){
		List<Product> productList = new ArrayList<Product>();

		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(GET_USER_PRODUCTS_BY_USER_ID);
			pr.setLong(1, userId);
			rs = pr.executeQuery();

			while (rs.next()) {
				productList.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"), rs.getString("description")));
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
		return productList;
	}

	
	@Override
	public Product getProductsBySearchId(long searchId) {
		Product product = null;

		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(GET_USER_PRODUCTS_BY_SEARCH_ID);
			pr.setLong(1, searchId);
			rs = pr.executeQuery();

			if (rs.next()) {
				product = new  Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"), rs.getString("description"));
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
		return product;
	}

	@Override
	public Product save(Product e, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
