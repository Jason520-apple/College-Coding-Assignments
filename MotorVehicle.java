/*
 * You are creating a MotorVehicle superclass, and one subclass named MonsterTruck. You will then create two
MonsterTruck objects, and display the information contained within those objects. You will also calculate the winning
percentage for each truck, and display that as well. You will be demonstrating your knowledge of inheritance in Java with
this assignment. 
 */
public class MotorVehicle {

	//variables
	private int truckYearBuilt = 2010;
	private String truckName =  "Big Foot";
	private String truckPowerPlant = "Diesel";
	
	
	//default constructor
	public MotorVehicle() {
		
	}
	
	//constructor that takes the above data members
	public MotorVehicle (int truckYearBuilt, String truckName, String truckPowerPlant) {
		this.truckYearBuilt = truckYearBuilt;
		this.truckName = truckName;
		this.truckPowerPlant = truckPowerPlant;
	}

	//getters and setters
	public int getTruckYearBuilt() {
		return truckYearBuilt;
	}

	public void setTruckYearBuilt(int truckYearBuilt) {
		this.truckYearBuilt = truckYearBuilt;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getTruckPowerPlant() {
		return truckPowerPlant;
	}

	public void setTruckPowerPlant(String truckPowerPlant) {
		this.truckPowerPlant = truckPowerPlant;
	}
	
	//toString
	public String toString () {
		return "Name: " + truckName + "\nPower Plant: " + truckPowerPlant + "\nYear Built: " + truckYearBuilt;
	}
	
	
	
}
