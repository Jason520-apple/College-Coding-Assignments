//extends is an inheritance keyword extends the previous MotorVehicle class, which is the superclass. MonsterTruck is the subclass (child class) and will add upon the MotorVechicle class
public class MonsterTruck extends MotorVehicle {

	//private variables
	private int numberOfWins;
	private int numberOfLosses;
	private String trick;
	
	
	public MonsterTruck () {
		
	}
	
	public MonsterTruck (int numberOfWins, int numberOfLosses, String trick) {
		this.numberOfWins = numberOfWins;
		this.numberOfLosses = numberOfLosses;
		this.trick = trick;
	}

	//getters and setters

	public int getNumberOfWins() {
		return numberOfWins;
	}

	public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}

	public int getNumberOfLosses() {
		return numberOfLosses;
	}

	public void setNumberOfLosses(int numberOfLosses) {
		this.numberOfLosses = numberOfLosses;
	}

	public String getTrick() {
		return trick;
	}

	public void setTrick(String trick) {
		this.trick = trick;
	}
	
	//calculating win percentage
	public double getWinPercentage () {
		return (numberOfWins + numberOfLosses) / numberOfWins;
	}
	
	//toString method which is not overridden, because we want to add upon it
	public String toString () {
		return "\nTrick: " + trick + "\nWin Percentage: " + String.format("%d%%", getWinPercentage()) ;
	}
	
	
	
}
