package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.solvd.OnlineShop.connectionPool.ConnectionPool;

public abstract class MySQLAbstractDAO {
	protected ConnectionPool pool;

	protected ResultSet rs;
	protected PreparedStatement pr;
	protected Connection con;

	public MySQLAbstractDAO() {
		pool = ConnectionPool.getInstance();
	}
}
