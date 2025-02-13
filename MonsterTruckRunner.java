import java.util.Scanner;

//this will run the MotorVehicle and MonsterTruck classes. i will create two monster trucks and populate data members
public class MonsterTruckRunner {

	public static void main(String[] args) {
		
		//create scanner
		Scanner input = new Scanner(System.in);
		
		//For the first monster truck, use the default constructor, followed by using setters to populate the values. Once
		//set, use the getters to display the information, and include a call to the winning percentage calculation method. 

		MonsterTruck monsterTruck1 = new MonsterTruck();
		
		System.out.print("Please enter the name of the Monster Truck: ");
		monsterTruck1.setTruckName(input.nextLine());
		
		
	}

}
