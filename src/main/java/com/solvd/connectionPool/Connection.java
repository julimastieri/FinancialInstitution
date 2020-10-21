package main.java.com.solvd.connectionPool;

public class Connection {
	private boolean available = true;

	public Connection() {}

	public Connection(boolean available) {
		super();
		this.available = available;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
