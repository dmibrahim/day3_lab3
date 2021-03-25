package day3_lab3;

public class CostSummaries {
	
	private String packageName;
	private String shippingCost;
	private String courierName;
	
	public CostSummaries(String packageName, String shippingCost, String courierName) {
		this.packageName = packageName;
		this.shippingCost = shippingCost;
		this.courierName = courierName;
	}

	public String toString() {
		return packageName+" $"+shippingCost+" "+courierName;
	}
}
