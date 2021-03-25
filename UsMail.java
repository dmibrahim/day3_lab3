package day3_lab3;

public class UsMail extends Courier{

	public double getShippingCost(Package p) {
		if(p.getWeight() <3)
			return 1.00;
		return 0.55*p.getWeight();
	}

}
