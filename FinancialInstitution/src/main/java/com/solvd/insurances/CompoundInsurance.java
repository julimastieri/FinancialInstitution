package main.java.com.solvd.insurances;

import java.util.ArrayList;
import java.util.List;

public class CompoundInsurance implements IInsurance {

	private List<IInsurance> insurances = new ArrayList<IInsurance>();

	public CompoundInsurance() {}
	
	public List<IInsurance> getInsurances() {
		return insurances;
	}

	@Override
	public double calculateCost() {
		return insurances.stream().mapToDouble(ins -> ins.calculateCost()).sum();
	}

}
