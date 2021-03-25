package day3_lab3;

public class UPS extends Courier {

	
	public double getShippingCost(Package p) {	
		return 0.45*p.getWeight();
	}

}
