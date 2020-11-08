package com.solvd.OnlineShop.dao.mysql;

import com.solvd.OnlineShop.dao.ICardDAO;
import com.solvd.OnlineShop.models.Card;

public class CardDAO extends MySQLAbstractDAO implements ICardDAO{

	@Override
	public Card save(Card e, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
