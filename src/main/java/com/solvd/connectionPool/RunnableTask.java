package main.java.com.solvd.connectionPool;

import org.apache.log4j.Logger;

public class RunnableTask implements Runnable {
	private static final Logger logger = Logger.getLogger(RunnableTask.class);
	private int id;
	private ConnectionPool cp;

	public RunnableTask() {}

	public RunnableTask(int id, ConnectionPool cp) {
		super();
		this.id = id;
		this.cp = cp;
	}

	@Override
	public void run() {
		cp.getAConnection();
		logger.info("Runnable #" + id + " get a connection successfully");
	}

}
