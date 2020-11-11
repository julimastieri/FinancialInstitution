package com.solvd.OnlineShop.dao;

import java.util.List;
import java.util.Optional;

import com.solvd.OnlineShop.models.SearchHistory;

public interface ISearchHistoryDAO extends IBaseDAO<SearchHistory> {
	public Optional<List<SearchHistory>> getSearchHistoryByUserId(long userId);
}
