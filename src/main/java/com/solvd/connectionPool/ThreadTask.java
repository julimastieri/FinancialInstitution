package main.java.com.solvd.connectionPool;

import org.apache.log4j.Logger;

public class ThreadTask extends Thread {
	private static final Logger logger = Logger.getLogger(ThreadTask.class);
	private int id;
	private ConnectionPool cp;

	public ThreadTask() {
	}

	public ThreadTask(int id, ConnectionPool cp) {
		super();
		this.id = id;
		this.cp = cp;
	}

	public void start() {
		this.run();
	}
	
	public void run() {
		try {
			cp.getAConnection();
		} catch (InterruptedException e) {
			logger.error(e);
		}
		logger.info("Thread #" + id + " get a connection successfully");
	}

}
