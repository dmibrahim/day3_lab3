package day3_lab3;

import java.util.List;

public class Fedex extends Courier {

public double getShippingCost(Package packg) {
		double cost = 0;
		  switch(packg.getZone()) {
		  case "IA": case "MT": case "OR": case "CA":
			  cost = 0.35*packg.getWeight();
			  break;
		  case "TX": case "UT":
			  cost = 0.30*packg.getWeight();
			  break;
		  case "FL": case "MA": case "OH":
			  cost = 0.55*packg.getWeight();
			  break;
	     default:
	    	 cost = 0.43*packg.getWeight();
	    	 break;
		  }
	return cost;
	}
}
