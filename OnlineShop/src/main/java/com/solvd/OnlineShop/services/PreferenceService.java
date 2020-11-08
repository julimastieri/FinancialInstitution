package com.solvd.OnlineShop.services;

import java.util.List;

import com.solvd.OnlineShop.dao.ICategoryDAO;
import com.solvd.OnlineShop.dao.IPreferenceDAO;
import com.solvd.OnlineShop.dao.mysql.CategoryDAO;
import com.solvd.OnlineShop.dao.mysql.PreferenceDAO;
import com.solvd.OnlineShop.models.Preference;

public class PreferenceService {
	IPreferenceDAO preferenceDao = new PreferenceDAO();
	ICategoryDAO categoryDao = new CategoryDAO();

	public List<Preference> getPreferencesByUserId(long userId) {
		List<Preference> preferenceList = preferenceDao.getPreferencesByUserId(userId);
		
		preferenceList.forEach( (p) -> p.setCategory(categoryDao.getCategoryByPreferenceId(p.getId())));
		
		return preferenceList;
		
	}
}
