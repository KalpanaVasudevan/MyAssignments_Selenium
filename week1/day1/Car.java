package week1.day1;

public class Car {
	
	
	public void driveCar() {
		// TODO Auto-generated method stub
		System.out.println("Driving My car");
	}
	
	public void applyBrake() {
		// TODO Auto-generated method stub
		System.out.println("Apply Brake");
	}
	
	public void soundHorn() {
		// TODO Auto-generated method stub
		System.out.println("Sound a Horn");
	}
	
	/*public boolean isPuncture()
	{
		boolean b =true;
		return b;		
	}
	*/
	
	public void isPucture() {
		// TODO Auto-generated method stub
		System.out.println("Vehicle is punctured");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car mycar = new Car();
		mycar.driveCar();
		mycar.applyBrake();
		mycar.soundHorn();
		mycar.isPucture();
		//boolean b1=mycar.isPuncture();
		//System.out.println(b1);
		
	}

}
