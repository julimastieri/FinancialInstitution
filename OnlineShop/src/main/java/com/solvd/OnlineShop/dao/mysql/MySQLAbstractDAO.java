package com.solvd.OnlineShop.dao.mysql;

import com.solvd.OnlineShop.connectionPool.ConnectionPool;

public abstract class MySQLAbstractDAO {
	protected ConnectionPool pool;

	public MySQLAbstractDAO() {
		pool = ConnectionPool.getInstance();
	}
}
