package main.java.com.solvd.insurances;

import java.util.ArrayList;

public class CompoundInsurance implements IInsurance {

	private ArrayList<IInsurance> insurances = new ArrayList<IInsurance>();

	public CompoundInsurance() {}
	
	public ArrayList<IInsurance> getInsurances() {
		return insurances;
	}

	@Override
	public double calculateCost() {
		return insurances.stream().mapToDouble(ins -> ins.calculateCost()).sum();
	}

}
