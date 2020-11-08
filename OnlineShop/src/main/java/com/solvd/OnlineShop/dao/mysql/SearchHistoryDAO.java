package com.solvd.OnlineShop.dao.mysql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.ISearchHistoryDAO;
import com.solvd.OnlineShop.models.SearchHistory;

public class SearchHistoryDAO extends MySQLAbstractDAO implements ISearchHistoryDAO {
	private static final Logger logger = Logger.getLogger(SearchHistoryDAO.class);
	private final static String GET_SEARCH_HISTORY_BY_USER_ID = "SELECT * FROM Search_Histories sh where sh.user_id=?";

	@Override
	public List<SearchHistory> getSearchHistoryByUserId(long userId) {
		List<SearchHistory> searchHistoryList = new ArrayList<SearchHistory>();

		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(GET_SEARCH_HISTORY_BY_USER_ID);
			pr.setLong(1, userId);
			rs = pr.executeQuery();

			while (rs.next()) {
				searchHistoryList.add(new SearchHistory(rs.getInt("id"), rs.getDate("date")));
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
		return searchHistoryList;
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
