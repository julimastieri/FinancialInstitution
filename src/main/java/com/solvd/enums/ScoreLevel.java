package main.java.com.solvd.enums;

public enum ScoreLevel {
	LOW("Low", 30),
	MEDIUM("Medium", 50), 
	HIGH("High", 80);

	private String level;
	private double minimum;
	
	ScoreLevel(String level, double minimum) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	public double getMinimum() {
		return minimum;
	}

}
