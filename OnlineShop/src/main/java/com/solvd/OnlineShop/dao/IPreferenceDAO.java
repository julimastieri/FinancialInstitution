package com.solvd.OnlineShop.dao;

import java.util.List;

import com.solvd.OnlineShop.models.Preference;

public interface IPreferenceDAO extends IBaseDAO<Preference> {
	public List<Preference> getPreferencesByUserId(long userId);
}
