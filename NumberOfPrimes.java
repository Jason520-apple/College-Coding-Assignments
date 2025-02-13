// Jason Vo

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;



public class NumberOfPrimes {

	public static void main(String[] args) {
		
		System.out.println("Enter file name: ");
		Scanner input = new Scanner(System.in);
		
		String fileName = input.nextLine();

		// file path: C:\Users\ancom\Desktop\Java\IntPrimes.txt
		
		try {
			File myFile = new File (fileName); // Insert file name here, open here
			Scanner myReader = new Scanner (myFile); // reading from myFile
			
			int counter = 0; // increment when find prime number
			
			while (myReader.hasNextLine()) { //While there are lines of text in the scanner
				
				// read in line
				String readLine = myReader.nextLine();
				
				// convert to type int
				int number =  Integer.parseInt(readLine);
				
				// call function that will determine
				if (isPrimeNumber(number)) {
					counter++;
				}
			}
			
			myReader.close();
			
			//display
			System.out.println("Valid prime number count: " + counter);
			
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
			System.exit(0);
		}
		
		
	}
	
		
		// Function to check if a number is prime
	    public static boolean isPrimeNumber(int number) {
	        if (number <= 1) return false; // 0 and 1 are not prime numbers
	        if (number == 2) return true; // 2 is prime
	        if (number % 2 == 0) return false; // exclude even numbers greater than 2

	        // Check divisibility up to the square root of n
	        for (int i = 3; i <= Math.sqrt(number); i += 2) {
	            if (number % i == 0) {
	                return false; // Not prime if divisible
	            }
	        }
	        return true; // If not divisible by any number, it's prime
		

	}

}
