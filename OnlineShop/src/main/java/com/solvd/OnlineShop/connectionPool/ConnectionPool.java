package com.solvd.OnlineShop.connectionPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	private final static int DEFAULT_POOL_SIZE = 5;
	private final int MAX_SIZE;
	private AtomicInteger createdConnections;
	private BlockingQueue<Connection> connections;
	private String url;
	private String user;
	private String password;
	private static ConnectionPool cp;

	private ConnectionPool(int size, String url, String user, String password) {
		MAX_SIZE = size;
		this.connections = new ArrayBlockingQueue<Connection>(size);
		this.createdConnections = new AtomicInteger();
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public synchronized static ConnectionPool getInstance(int size, String url, String user, String password) {
		if (cp == null) {
			return new ConnectionPool(size, url, user, password);
		}
		return cp;
	}

	public synchronized static ConnectionPool getInstance(String url, String user, String password) {
		if (cp == null) {
			return new ConnectionPool(DEFAULT_POOL_SIZE, url, user, password);
		}
		return cp;
	}

	public Connection getAConnection() throws InterruptedException, SQLException {
		synchronized (this) {
			if ((connections.size() == 0) && (createdConnections.get() < MAX_SIZE)) {
				Connection con = DriverManager.getConnection(url, user, password);
				connections.put(con);
				createdConnections.incrementAndGet();
			}
		}
		return connections.take();
	}

	public void releaseConnection(Connection connection) throws InterruptedException {
		connections.put(connection);
	}

	public void closeAllConnections() {
		connections.clear();
		createdConnections = new AtomicInteger();
	}

}
