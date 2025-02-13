// Jason Vo


public class Vo_CargoPlane implements Vo_AirVehicle {

/* This class will have the following private data members:
Number of Engines, type int
Number of Crew Members, type int
Name of Plane, type String
Name of Manufacturer, type String*/

	private int numberOfEngines;
	private int numberOfCrewMembers;
	private String nameOfPlane;
	private String nameOfManufacturer;
	
	//default constructor
	public Vo_CargoPlane () {
			
	}
		
	//constructor that accepts input for data members
	public Vo_CargoPlane (int numberOfEngines, int numberOfCrewMembers, String nameOfPlane, String nameOfManufacturer) {
			this.numberOfEngines = numberOfEngines;
			this.numberOfCrewMembers = numberOfCrewMembers;
			this.nameOfPlane = nameOfPlane;
			this.nameOfManufacturer = nameOfManufacturer;
	}
	
	//getters and setters
	public int getNumberOfEngines() {
		return numberOfEngines;
	}

	public void setNumberOfEngines(int numberOfEngines) {
		this.numberOfEngines = numberOfEngines;
	}

	public int getNumberOfCrewMembers() {
		return numberOfCrewMembers;
	}

	public void setNumberOfCrewMembers(int numberOfCrewMembers) {
		this.numberOfCrewMembers = numberOfCrewMembers;
	}

	public String getNameOfPlane() {
		return nameOfPlane;
	}

	public void setNameOfPlane(String nameOfPlane) {
		this.nameOfPlane = nameOfPlane;
	}

	public String getNameOfManufacturer() {
		return nameOfManufacturer;
	}

	public void setNameOfManufacturer(String nameOfManufacturer) {
		this.nameOfManufacturer = nameOfManufacturer;
	}

	
	//implement abstract methods from AirVehicle interface
	@Override
	public void avTakeoff() {
		System.out.println(nameOfPlane + " has started the takeoff roll.");	
		
		//cargo plane is slower, so it will take a while
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void avFly() {
		System.out.println(nameOfPlane + " has taken off and is now flying.");
		System.out.println("Flying...");		
		
		//it will take a while for the cargo plane to land
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void avLand() {
		System.out.println(nameOfPlane + " has successfully landed.");
		
	}
	
	//toString method
		public String toString () {
			
			return "\n###################\n" + "# CargoPlane Info #\n" + "CargoPlane [numberOfEngines = " + 
			numberOfEngines + ", numCrewMembers = " + numberOfCrewMembers + 
			", nameOfPlane = " + nameOfPlane + ", manufacturer = " + nameOfManufacturer + "]";
		}
	
}
