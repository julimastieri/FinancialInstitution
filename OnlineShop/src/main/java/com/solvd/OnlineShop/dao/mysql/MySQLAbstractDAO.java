package com.solvd.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.solvd.OnlineShop.connectionPool.ConnectionPool;

public abstract class MySQLAbstractDAO {
	protected ConnectionPool pool;

	protected ResultSet rs;
	protected PreparedStatement ps;
	protected Connection conn;

	public MySQLAbstractDAO() {
		pool = ConnectionPool.getInstance("jdbc:mysql://localhost:3306/online_shop", "root", "my-secret-pw"); 
	}
}
