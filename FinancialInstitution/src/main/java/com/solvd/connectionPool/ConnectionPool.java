package main.java.com.solvd.connectionPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {
	private final static int DEFAULT_POOL_SIZE = 5;
	private final int MAX_SIZE;
	private AtomicInteger createdConnections;
	private BlockingQueue<Connection> connections;
	private static ConnectionPool cp;

	private ConnectionPool(int size) {
		MAX_SIZE = size;
		this.connections = new ArrayBlockingQueue<Connection>(size);
		this.createdConnections = new AtomicInteger();
	}

	public synchronized static ConnectionPool getInstance(int size) {
		if (cp == null) {
			return new ConnectionPool(size);
		}
		return cp;
	}

	public synchronized static ConnectionPool getInstance() {
		if (cp == null) {
			return new ConnectionPool(DEFAULT_POOL_SIZE);
		}
		return cp;
	}

	public Connection getAConnection() throws InterruptedException {
		synchronized(this) {
			if((connections.size() == 0) && (createdConnections.get() < MAX_SIZE)){
				connections.put(new Connection());
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
