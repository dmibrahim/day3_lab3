package day3_lab3;

public class Package {
	
	private String description;
	private double weight;
	private String zone;
	private Sender sender;
	
	public Package(String description, double weight, String zone) {
		this.description = description;
		this.weight = weight;
		this.zone = zone;
	}
	
	public Sender getSender() {
		return sender;
	}
	
	public void setSender(Sender sender) {
		this.sender=sender;
	}
	public String getDescription() {
		return description;
	}
	public double getWeight() {
		return weight;
	}
	public String getZone() {
		return zone;
	}
}
