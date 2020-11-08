package com.solvd.OnlineShop.dao.mysql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IPreferenceDAO;
import com.solvd.OnlineShop.models.Preference;

public class PreferenceDAO extends MySQLAbstractDAO implements IPreferenceDAO {

	private static final Logger logger = Logger.getLogger(PreferenceDAO.class);
	private final static String GET_USER_PREFERENCES = "SELECT * FROM Preferences p where p.user_id=?";

	@Override
	public List<Preference> getPreferencesByUserId(long userId) {
		List<Preference> preferenceList = new ArrayList<Preference>();

		try {
			con = pool.getAConnection();
			pr = con.prepareStatement(GET_USER_PREFERENCES);
			pr.setLong(1, userId);
			rs = pr.executeQuery();

			while (rs.next()) {
				preferenceList.add(new Preference(rs.getInt("id")));
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
		return preferenceList;

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
