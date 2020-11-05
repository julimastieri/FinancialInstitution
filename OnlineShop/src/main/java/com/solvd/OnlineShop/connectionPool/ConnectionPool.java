package com.solvd.OnlineShop.connectionPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	private final static int MAX_CONNECTIONS = 5;
	private int createdConnections = 0;
	private BlockingQueue<Connection> connections = new ArrayBlockingQueue<Connection>(MAX_CONNECTIONS);

	public ConnectionPool() {
	}

	public Connection getAConnection() throws InterruptedException, SQLException {
		synchronized(this) {
			if((connections.size() == 0) && (createdConnections < MAX_CONNECTIONS)){
				Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/online_shop", "root", "my-secret-pw" );
				connections.put(con);
				createdConnections++;
			}
			
		}
		return connections.take();
	}

	public void releaseConnection(Connection connection) throws InterruptedException {
		connections.put(connection);
	}

	public void closeAllConnections() {
		connections.clear();
		createdConnections = 0;
	}

}
