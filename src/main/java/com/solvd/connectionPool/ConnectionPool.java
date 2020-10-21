package main.java.com.solvd.connectionPool;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class ConnectionPool {
	private static final Logger logger = Logger.getLogger(ConnectionPool.class);
	private final static int MAX_CONNECTIONS = 5;
	private int availablesConnections = MAX_CONNECTIONS;
	private ArrayList<Connection> connections = new ArrayList<Connection>();

	public ConnectionPool() {
	}

	public synchronized Connection getAConnection() {
		
		while (availablesConnections == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				logger.error(e);
			}
		}
		
		Connection connection = connections.stream().filter(c -> c.isAvailable()).findFirst().orElse(null);
		if (connection != null) {
			connection.setAvailable(false);
			availablesConnections--;
			return connection;
		} else if (connections.size() < MAX_CONNECTIONS) {
			Connection newConnection = new Connection(false);
			connections.add(newConnection);
			availablesConnections--;
			return newConnection;
		}
		
		return null;
	}

	public synchronized void releaseConnection(Connection connection) {
		int index = connections.indexOf(connection);
		if (index != -1) {
			connections.get(index).setAvailable(true);
			availablesConnections++;
			this.notify();
		}
	}

	public void closeAllConnections() {
		connections.clear();
	}

}
