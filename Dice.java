import java.util.Random;

public class Dice {
	
	Random rand;
	int minNumber;
	int maxNumber;
	
	
	public Dice(int minNumber, int maxNumber) {
		
		rand = new Random();
		this.minNumber = minNumber;
		this.maxNumber = maxNumber;
		
	}
	
	

	public int roll() {
		return rand.nextInt(maxNumber - minNumber + 1) + minNumber;
	}
	
}
