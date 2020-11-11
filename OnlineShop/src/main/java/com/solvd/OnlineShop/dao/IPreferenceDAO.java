package com.solvd.OnlineShop.dao;

import java.util.List;
import java.util.Optional;

import com.solvd.OnlineShop.models.Preference;

public interface IPreferenceDAO extends IBaseDAO<Preference> {
	public Optional<List<Preference>> getPreferencesByUserId(long userId);
}
