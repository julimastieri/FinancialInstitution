package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.ISearchHistoryDAO;
import com.solvd.OnlineShop.models.SearchHistory;

public class SearchHistoryDAO extends MySQLAbstractDAO implements ISearchHistoryDAO {
	private static final Logger logger = Logger.getLogger(SearchHistoryDAO.class);
	private final static String GET_SEARCH_HISTORY_BY_USER_ID = "SELECT * FROM Search_Histories sh where sh.user_id=?";

	private SearchHistory getAllAtributesFromTable(ResultSet rs) throws SQLException {
		return new SearchHistory(rs.getInt("id"), rs.getDate("date"));
	}

	@Override
	public Optional<List<SearchHistory>> getSearchHistoryByUserId(long userId) {
		List<SearchHistory> searchHistoryList = new ArrayList<SearchHistory>();

		try (Connection con = pool.getConnection();
				PreparedStatement pr = con.prepareStatement(GET_SEARCH_HISTORY_BY_USER_ID);
				ResultSet rs = pr.executeQuery();) {

			pr.setLong(1, userId);
			while (rs.next()) {
				searchHistoryList.add(getAllAtributesFromTable(rs));
			}

		} catch (InterruptedException | SQLException e) {
			logger.error(e);
		}

		return Optional.of(searchHistoryList);
	}

	@Override
	public SearchHistory save(SearchHistory e, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
