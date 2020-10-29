package main.java.com.solvd.interfaces;

@FunctionalInterface
public interface Contactable {
	String MESSAGE = "Message send by ";
	public void sendEmail();
}
