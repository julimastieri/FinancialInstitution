package com.solvd.OnlineShop.dao.mysql;

import com.solvd.OnlineShop.dao.ITransactionDAO;
import com.solvd.OnlineShop.models.Transaction;

public class TransactionDAO extends MySQLAbstractDAO implements ITransactionDAO {

	@Override
	public Transaction save(Transaction e, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
