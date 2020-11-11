package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IPreferenceDAO;
import com.solvd.OnlineShop.models.Preference;

public class PreferenceDAO extends MySQLAbstractDAO implements IPreferenceDAO {

	private static final Logger logger = Logger.getLogger(PreferenceDAO.class);
	private final static String GET_USER_PREFERENCES = "SELECT * FROM Preferences p where p.user_id=?";

	@Override
	public Optional<List<Preference>> getPreferencesByUserId(long userId) {
		List<Preference> preferenceList = new ArrayList<Preference>();

		try (Connection con = pool.getAConnection();
				PreparedStatement pr = con.prepareStatement(GET_USER_PREFERENCES);
				ResultSet rs = pr.executeQuery();){

			pr.setLong(1, userId);
			while (rs.next()) {
				preferenceList.add(new Preference(rs.getInt("id")));
			}

		} catch (InterruptedException | SQLException e) {
			logger.error(e);
		}

		return Optional.of(preferenceList);
	}

	@Override
	public Preference save(Preference e, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
