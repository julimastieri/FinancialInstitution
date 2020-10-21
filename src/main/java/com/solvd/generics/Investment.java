package main.java.com.solvd.generics;

import main.java.com.solvd.interfaces.Invertible;
import main.java.com.solvd.people.Person;

public class Investment<I extends Invertible, T extends Person> {
	private I invertible;
	private T investor;
	
	public Investment() {}
	
	public Investment(I thing, T investor) {
		super();
		this.invertible = thing;
		this.investor = investor;
	}
	
	public I getThing() {
		return invertible;
	}
	
	public T getInvestor() {
		return investor;
	}
	
	public void invest(double amount) {
		invertible.invest(amount);
	}
	
}
