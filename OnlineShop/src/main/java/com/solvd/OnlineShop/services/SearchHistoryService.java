package com.solvd.OnlineShop.services;

import java.util.List;

import com.solvd.OnlineShop.dao.IProductDAO;
import com.solvd.OnlineShop.dao.ISearchHistoryDAO;
import com.solvd.OnlineShop.dao.mysql.ProductDAO;
import com.solvd.OnlineShop.dao.mysql.SearchHistoryDAO;
import com.solvd.OnlineShop.models.SearchHistory;

public class SearchHistoryService {
	ISearchHistoryDAO searchDao = new SearchHistoryDAO();
	IProductDAO productDao = new ProductDAO();

	public List<SearchHistory> getSearchHistoryByUserId(long userId) {
		List<SearchHistory> searchHistoryList = searchDao.getSearchHistoryByUserId(userId);

		searchHistoryList.forEach((sh) -> sh.setProduct(productDao.getProductsBySearchId(sh.getId())));

		return searchHistoryList;

	}

}
