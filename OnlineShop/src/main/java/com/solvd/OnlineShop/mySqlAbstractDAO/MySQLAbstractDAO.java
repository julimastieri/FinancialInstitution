package com.solvd.OnlineShop.mySqlAbstractDAO;

import com.solvd.OnlineShop.connectionPool.ConnectionPool;

public abstract class MySQLAbstractDAO {
	protected static ConnectionPool pool = new ConnectionPool();
}
