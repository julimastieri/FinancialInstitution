package com.solvd.OnlineShop.connectionPool;

import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	private static final Logger logger = Logger.getLogger(ConnectionPool.class);
	private final int MAX_SIZE;
	private AtomicInteger createdConnections;
	private BlockingQueue<Connection> connections;
	private String url;
	private String username;
	private String password;
	private static ConnectionPool cp;

	private ConnectionPool(int size) {
		MAX_SIZE = size;
		this.connections = new ArrayBlockingQueue<Connection>(size);
		this.createdConnections = new AtomicInteger();

		Properties props = new Properties();
		File file = FileUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/db.properties");
		try {
			props.load(new FileReader(file));
			String driver = props.getProperty("jdbc.driver");
			if (driver != null) {
				Class.forName(driver);
			}
		} catch (IOException | ClassNotFoundException e) {
			logger.error(e);
		}

		this.url = props.getProperty("jdbc.url");
		this.username = props.getProperty("jdbc.username");
		this.password = props.getProperty("jdbc.password");
	}

	public synchronized static ConnectionPool getInstance(int size) {
		if (cp == null) {
			return new ConnectionPool(size);
		}
		return cp;
	}

	public Connection getConnection() throws InterruptedException, SQLException {
		synchronized (this) {
			if ((connections.size() == 0) && (createdConnections.get() < MAX_SIZE)) {
				Connection con = DriverManager.getConnection(url, username, password);
				connections.put(con);
				createdConnections.incrementAndGet();
			}
			return connections.take();
		}
	}

	public void releaseConnection(Connection connection) throws InterruptedException {
		connections.put(connection);
	}

	public void closeAllConnections() {
		connections.clear();
		createdConnections = new AtomicInteger();
	}
}
