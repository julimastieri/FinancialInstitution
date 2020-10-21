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
		Connection connection = connections.stream().filter(c -> c.isAvailable()).findFirst().orElse(null);
		if (connection != null) {
			connection.setAvailable(false);
			return connection;
		} else if (createdConnections < MAX_CONNECTIONS) {
			Connection newConnection = new Connection(false);
			createdConnections++;
			return newConnection;
		} else {
			Connection c = connections.take();
			System.out.println(c);
			return c;
		}
	}

	public void releaseConnection(Connection connection) throws InterruptedException {
		connection.setAvailable(true);
		connections.put(connection);
	}

	public void closeAllConnections() {
		connections.clear();
	}

}
