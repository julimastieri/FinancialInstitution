package main.java.com.solvd.connectionPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
	private final static int MAX_CONNECTIONS = 5;
	private int createdConnections = 0;
	private BlockingQueue<Connection> connections = new ArrayBlockingQueue<Connection>(MAX_CONNECTIONS);

	public ConnectionPool() {
	}

	public Connection getAConnection() throws InterruptedException {
		synchronized(this) {
			if((connections.size() == 0) && (createdConnections < MAX_CONNECTIONS)){
				connections.put(new Connection());
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
