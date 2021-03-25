package day3_lab3;

import java.util.List;

public class Sender {
	private String name;
	private String category;
	private String phone;
	private String email;
	List<Package> packages;
	
	public Sender(String name, String category, String phone, String email, List<Package> packages) {
		this.name = name;
		this.category = category;
		this.phone = phone;
		this.email = email;
		this.packages = packages;
	}
	
	public String getCategory() {
		return category;
	}

}
