package day3_lab3;

public class Discount  implements IDiscount{
   private  double studentRate;
   private  double seniorRate;
   public Discount() {
	studentRate = 10;
	seniorRate =  15;
    }
  public void setStudentRate(double newRate) {
	  studentRate = newRate;
  }
  public void setSeniorRate(double newRate) {
	  seniorRate = newRate;
  }
	public double applyStudentDiscount(double cost) {
	
		return cost- (cost*studentRate/100);
	}

	@Override
	public double applySeniorityDiscount(double cost) {
	
		return cost-(cost*seniorRate/100);
	}

}
