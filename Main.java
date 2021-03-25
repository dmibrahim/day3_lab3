package day3_lab3;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {		
		//Sender object
		 Sender sender;
		Courier courier = new Courier();
		//List of Couriers
		List<Courier> couriers = new ArrayList<Courier>();
		couriers.add(new Fedex());
		couriers.add(new UsMail());
		couriers.add(new UPS());
		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("How many packages do you have? (enter number only)");
		String input = sc.nextLine();
		String packageDesc;
		double weight;
		String zone;
		boolean isValidNumber = checkEnteredValueIsNumber(input);
		if(!isValidNumber) {
		    input = sc.nextLine();	
		}
		
		int numOfPackages = Integer.parseInt(input);
		while(numOfPackages >0) {
			System.out.println("Enter package Description");
			packageDesc = sc.nextLine();
			System.out.println("Enter package weight");
			String _weight = sc.nextLine();
			boolean isWeightValid = checkWeight(_weight);
			if(!isWeightValid) {
				_weight = sc.nextLine();
			}
			weight = Double.parseDouble(_weight);
			System.out.println("Enter zone (states initial such IA, FL)");
			zone = sc.nextLine();
			//Add package to courier
			courier.setPackage(new Package(packageDesc, weight, zone));
			//Decrement number of packages
		 	numOfPackages--;	 	
		}
		
		//Get sender information:
		if(courier.getPackage().size() >0) {
			System.out.println("Enter your name");
			String name= sc.nextLine();
			System.out.println("Enter your age");
			String ageInput= sc.nextLine();
			if(!checkEnteredValueIsNumber(ageInput)) {
				ageInput= sc.nextLine();
			}
			int age = Integer.parseInt(ageInput);
			System.out.println("Enter your phone number");
			String phone  = sc.nextLine();
			
			System.out.println("Enter youe email");
			String email = sc.nextLine();
			System.out.println("Are you a student? (select 1 or 2)");
			System.out.println("1. YES");
			System.out.println("2. NO");
			String student = sc.nextLine();
			String category= "Normal Adult";
			if(student.equals("1")) {
				category = "Student";
			}
			if(age >=65) {
				category = "Senior";
			}
		
			sender = new Sender(name, category, phone, email, courier.getPackage());
			for(Package pkg: courier.getPackage()) {
				pkg.setSender(sender);
			}
		}
		
		List<CostSummaries> shippingCosts = new ArrayList<CostSummaries>();
		for(Package pkg: courier.getPackage()) {
			double smallestCost = 0;
			String _courier = "";
			for(Courier cr: couriers) {
				double price = cr.getShippingCost(pkg);
				if(smallestCost==0 || smallestCost>price) {
					smallestCost =price;
					_courier = cr.getClass().getSimpleName();
				}
				
			}
			shippingCosts.add(new CostSummaries(pkg.getDescription(),String.format("%.2f", smallestCost), _courier));	
			
		}
		//Provide various shipping options with minimum costs
		System.out.println("Shipping options with minimum costs");
		System.out.println("===============Without discounts==================================");
		for(CostSummaries costdetails: shippingCosts)
			System.out.println(costdetails); 
		
		System.out.println("===============With discounts==================================");
		List<CostSummaries> discounted = new ArrayList<CostSummaries>();
		Discount discObj= new Discount();
		for(Package pkg: courier.getPackage()) {
			double smallestCost = 0;
			String _courier = "";
			for(Courier cr: couriers) {
				double price = cr.getShippingCost(pkg);
				if(smallestCost==0 || smallestCost>price) {
					smallestCost =price;
					_courier = cr.getClass().getSimpleName();
				}
				
			}
			//Apply discounts
			if(pkg.getSender().getCategory().equalsIgnoreCase("student")) {
				smallestCost = discObj.applyStudentDiscount(smallestCost);
			}
			if(pkg.getSender().getCategory().equalsIgnoreCase("Senior")) {
				smallestCost = discObj.applySeniorityDiscount(smallestCost);
			}
			String strDouble = String.format("%.2f", smallestCost);
			discounted.add(new CostSummaries(pkg.getDescription(),strDouble, _courier));	
			
		}
		
		for(CostSummaries  discCost: discounted)
			 System.out.println(discCost);
		
	}
	
	static boolean checkEnteredValueIsNumber(String input) {
		try {
			int value = Integer.parseInt(input);	
			return true;
		}
		catch (NumberFormatException  e) {
			System.out.println("Entered value is not a valid number, please enter valid number");
			return false;
		}
		
	}
	static boolean checkWeight(String input) {
		try {
			double value = Double.parseDouble(input);	
			return true;
		}
		catch (NumberFormatException  e) {
			System.out.println("Entered value is not a valid weight, please enter valid weight");
			return false;
		}
		
	}

}
