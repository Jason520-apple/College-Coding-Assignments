// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 2 Homework - Sieve of Eratosthenes


import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		
		// Scanner
		Scanner input = new Scanner(System.in);
		
		// Variables to hold start and stop values
		int startValue = 0;
		int stopValue = 0;
		
		
		// Display greeting
		System.out.println("Hello, this program will simulate the Sieve of Eratosthenes, " + 
							"a method of finding prime numbers.");
		
		
		// User input
		if (args.length == 0) {
		
		
		// Prompting for a start value > 1
		System.out.println("Please enter a starting value that is greater than 1: ");
		startValue = input.nextInt();
		
		// Input validation
		while (startValue <= 1) {
			
			System.out.println("Error, must enter a starting value that is greater than 1." +
							"Please enter another number: ");
			startValue = input.nextInt();
			
		}
		
		// Prompt for a stop value
		System.out.println("Please enter a stop value: ");
		stopValue = input.nextInt();
		
		// Input validation
		while (stopValue <= 1) {
					
			System.out.println("Error, must enter a stop value that is greater than the start value." +
									"Please enter another number: ");
			stopValue = input.nextInt();
					
		}
		
		}
		
		// If command line parameters are used
		else if (args.length == 2) {
			
			startValue = Integer.parseInt(args[0]);
			if (startValue <= 1) {
				
				System.out.println("Error, must enter a starting value that is greater than 1." +
								"Please enter another number: ");
				System.exit(0); // exit the program if number entered is invalid
				
			}
			stopValue = Integer.parseInt(args[1]);
			
		}
		
		
		// Catching error in command line parameters
		else {
			
			System.out.println("Error, only two command line parameters are allowed.");
			System.exit(0);
			
		}
		
		System.out.println("\nRunning Sieve of Eratosthenes algorithm: \n");
		
		// Calling the sieve
		Sieve (startValue, stopValue);
		
		System.out.println("\nSieve of Eratosthenes program has been completed from " + startValue + 
						" to " + stopValue + "!\n");
		
		input.close();
		
	}
	
	
	// I received help from: https://www.geeksforgeeks.org/sieve-of-eratosthenes/5
	
	// This will count all prime numbers within the range of the startValue and the stopValue
	public static void Sieve (int startValue, int stopValue) {
		
		int counter = 0; // To hold the total number of primes found in the range
		
		
		// Array 
		boolean[] isPrime = new boolean [stopValue];
		
		// Marking each array element as true, since they are initially set to false
		for (int i = 0 ; i <= stopValue - 1 ; i++) {
			isPrime[i] = true;
		}
		
		// Don't need to mark the number 1 as false since the user is not allowed to enter a number less than 1
		
		// Sieve algorithm, will go through and cross out numbers that are multiples of prime numbers
		// Numbers that are crossed out will be marked as false, at the end will only print numbers/elements of the array which are true
		// Numbers which are multiples of prime numbers will be crossed out
		for (int c = 2 ; c * c <= stopValue - 1 ; c++) {
			
			// For numbers which are still true
			if (isPrime[c]) {
				
				// if there are multiples of the prime number, they will be crossed out
				for (int j = c * c ; j <= stopValue - 1; j += c) {
					isPrime[j] = false;
					
				}
			}
			
		}
		
		// Increment counter for elements that are marked true in the isPrime array (the prime numbers within the range of the start and the stop value)
		for (int a = startValue ; a <= stopValue - 1 ; a++) {
			if (isPrime[a] == true) { // if true
				counter++; // incrementing the counter
			}
		}
		
		
		System.out.println("\nThe total number of primes found is: " + counter + "\n");
	
	}

}
