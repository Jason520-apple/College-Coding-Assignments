// Jason Vo

import java.util.Scanner;

public class Vo_AirVehicleDemo {

    public static void main(String[] args) throws InterruptedException {

        // Create scanner input to ask the user if they are ready for take off
        Scanner input = new Scanner(System.in);

        // Create one fighterJet and one CargoPlane object
        Vo_FighterJet fighterJet = new Vo_FighterJet(2, 1, "F-22", "Lockheed Martin");
        Vo_CargoPlane cargoPlane = new Vo_CargoPlane(4, 3, "C-17", "Boeing");

        // Simulate fighter jet operations through the use of separate methods that are able to be reused
        System.out.println(fighterJet);
        waitForTakeoff(input);
        simulateFlight(fighterJet);

        // Simulate cargo plane operations
        System.out.println(cargoPlane);
        waitForTakeoff(input);
        simulateFlight(cargoPlane);

        input.close();
    }

    // Validates user input to check readiness for take off using if statements.
    private static void waitForTakeoff(Scanner input) throws InterruptedException  {
    	char status;

        do {
            System.out.print("Ready for takeoff? (y/n): ");
            String rawInput = input.next();
            status = rawInput.charAt(0);

            if (status != 'y' && status != 'n') {
                System.out.println("Invalid input. Please enter 'y' or 'n' (lowercase).");
            } else if (status == 'n') {
                System.out.println("Please make sure takeoff preparations are complete.");
                Thread.sleep(5000); // Wait for 5 seconds
            }
        } while (status != 'y');
    }

    // Simulates the flight operations of a given air vehicle.
    private static void simulateFlight(Vo_AirVehicle vehicle) {
        vehicle.avTakeoff();
        vehicle.avFly();
        if (vehicle instanceof Vo_FighterJet) {
            ((Vo_FighterJet) vehicle).breakSoundBarrier();
        }
        vehicle.avLand();
    }
}