// Jason Vo

public class Vo_FighterJet implements Vo_AirVehicle, Vo_SoundBarrier {

	//stating private data members/fields
	
/*•	Number of Engines, type int
•	Number of Crew Members, type int
•	Name of Jet, type String
•	Name of Manufacturer, type String*/
	
	private int numberOfEngines;
	private int numberOfCrewMembers;
	private String nameOfJet;
	private String nameOfManufacturer;
	
	//default constructor
	public Vo_FighterJet () {
		
	}
	
	//constructor that accepts input for data members
	public Vo_FighterJet (int numberOfEngines, int numberOfCrewMembers, String nameOfJet, String nameOfManufacturer) {
		this.numberOfEngines = numberOfEngines;
		this.numberOfCrewMembers = numberOfCrewMembers;
		this.nameOfJet = nameOfJet;
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
	public String getNameOfJet() {
		return nameOfJet;
	}
	public void setNameOfJet(String nameOfJet) {
		this.nameOfJet = nameOfJet;
	}
	public String getNameOfManufacturer() {
		return nameOfManufacturer;
	}
	public void setNameOfManufacturer(String nameOfManufacturer) {
		this.nameOfManufacturer = nameOfManufacturer;
	}
	
	
	//implement the interfaces' abstract methods
	
	//implementing AirVehicle's abstract methods
	@Override
	public void avTakeoff() {
		System.out.println(nameOfJet + " has started the takeoff roll.");
		
		//create a time delay in java using Thread.sleep, will be faster than cargo plane
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void avFly() {
		System.out.println(nameOfJet + " has taken off and is now flying.");
		System.out.println("Flying...");
		
		//create a time delay in java using Thread.sleep, a jet is faster than a cargo plane so it will take a shorter amount of time
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void avLand() {
		System.out.println(nameOfJet + " has successfully landed.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//implementing SoundBarrier's abstract method
	@Override
	public void breakSoundBarrier() {
		System.out.println(nameOfJet + " has broken the sound barrier!");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//toString method
	public String toString () {
				
		return "\n###################\n" + "# FighterJet Info #\n" + "FighterJet [numberOfEngines = " + 
				numberOfEngines + ", numCrewMembers = " + numberOfCrewMembers + 
				", nameOfJet = " + nameOfJet + ", manufacturer = " + nameOfManufacturer + "]";
			}
	
}
