package day3_lab3;

import java.util.ArrayList;
import java.util.List;

public  class Courier {
	
	private List<Package> packages;
	
	public Courier() {
		packages = new ArrayList<Package>();
	}
	
	public void setPackages(List<Package> pkg) {
		this.packages= pkg;
	}
	public void setPackage(Package pkg) {
		packages.add(pkg);
	}
	
	public List<Package> getPackage(){
		return packages;
	}
	public  double getShippingCost(Package p) {
	return 0;
	}

}
