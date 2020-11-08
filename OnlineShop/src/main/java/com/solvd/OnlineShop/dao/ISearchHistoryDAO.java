package com.solvd.OnlineShop.dao;

import java.util.List;

import com.solvd.OnlineShop.models.SearchHistory;

public interface ISearchHistoryDAO extends IBaseDAO<SearchHistory> {
	public List<SearchHistory> getSearchHistoryByUserId(long userId);
}
