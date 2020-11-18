package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IProductDAO;
import com.solvd.OnlineShop.models.Product;

public class ProductDAO extends MySQLAbstractDAO implements IProductDAO {
	private static final Logger logger = Logger.getLogger(ProductDAO.class);
	private final static String GET_USER_PRODUCTS_BY_USER_ID = "SELECT * FROM Products p where p.user_id=?";
	private final static String GET_USER_PRODUCTS_BY_SEARCH_ID = "SELECT * FROM Search_Histories sh LEFT JOIN Products p ON sh.product_id=p.id where sh.id=?";

	private Product getAllAtributesFromTable(ResultSet rs) throws SQLException {
		return new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"), rs.getString("description"));
	}
	
	public Optional<List<Product>> getProductsByUserId (long userId){
		List<Product> productList = new ArrayList<Product>();

		try (Connection con = pool.getConnection();
				PreparedStatement pr = con.prepareStatement(GET_USER_PRODUCTS_BY_USER_ID);
				ResultSet rs = pr.executeQuery();) {
			
			pr.setLong(1, userId); 
			while (rs.next()) {
				productList.add(getAllAtributesFromTable(rs));
			}

		} catch (InterruptedException | SQLException e) {
			logger.error(e);
		}
		return Optional.of(productList);
	}

	
	@Override
	public Optional<Product> getProductsBySearchId(long searchId) {
		Product product = null;

		try (Connection con = pool.getConnection();
				PreparedStatement pr = con.prepareStatement(GET_USER_PRODUCTS_BY_SEARCH_ID);
				ResultSet rs = pr.executeQuery();){

			pr.setLong(1, searchId);
			if (rs.next()) {
				product = getAllAtributesFromTable(rs);
			}

		} catch (InterruptedException | SQLException e) {
			logger.error(e);
		}
		return Optional.ofNullable(product);
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
