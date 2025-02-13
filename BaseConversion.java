// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 1 Homework - Base Conversions

import java.math.BigInteger;
import java.util.Scanner;


public class BaseConversion {

	public static void main(String[] args) {
				
		// Display friendly greeting
		System.out.println("Hello, this program will perform base conversions.");
		
		// Variables to hold the number 
		String theValue = "";
		int theInitialBase = 0;
		int theFinalBase = 0;

		// User input
		if (args.length == 0) {
			Scanner input = new Scanner(System.in);
			System.out.print("Please enter initial value: ");
			theValue = input.nextLine().toUpperCase(); 	// make sure the user input is set to all uppercase to account for lowercase letters
			System.out.print("Please enter inital base: ");
			theInitialBase = input.nextInt();
			System.out.print("Please enter final base: ");
			theFinalBase = input.nextInt();
		}
				
		// Reading from command line three parameters
		else if (args.length == 3) {
			theValue = (args[0].toUpperCase()); // make sure the user input is set to all uppercase to account for lowercase letters
			theInitialBase = Integer.parseInt(args[1]);
			theFinalBase = Integer.parseInt(args[2]);
			
		}
		
		// Error statement
		else {
			System.out.println("Usage: Base Conversion [initialValue initialBase finalBase]");
			System.exit(0);
			
		}
		
		System.out.println();
		System.out.println("Converting " + theValue + " from base " + theInitialBase + " to base " + theFinalBase);
		

		

		
		// Check if the String is a valid integer by calling isValid method
		boolean isValid = isValidInteger(theValue, theInitialBase);
		
		// If invalid then exit the program
		if (!isValid) {
			System.out.println("Error. The value entered is invalid and is not a legal expression of a number in the initial base.");
			System.exit(0);
		}
		
		
		// Call the convertInteger method
		String convertValue = convertInteger(theValue, theInitialBase, theFinalBase);
		
		System.out.println(convertValue + " is the converted value of " + theValue + 
							" from the initial base " + theInitialBase + " to the final base " + theFinalBase);
			
	}
	
	// Used this yt video as help: https://www.youtube.com/watch?v=E1kOFHhNij4	
	public static boolean isValidInteger(String theValue, int theInitialBase) {
			
		// In base-n, valid digits are from 0 to n-1. For bases greater than 10, letters (A-Z) represent values 10 to 35.
		
		char chDigit; // temporary variable which will be used to store the letter or digit that will be checked against the conditions below in the for loop
		boolean status = true; // will be used to return status at the end, if it passes all of the conditions in the for loop
		
		// loops through each character
		for (int i = 0 ; i < theValue.length() ; i++) {
			chDigit = theValue.toUpperCase().charAt(i); // set to uppercase
			
			// checks if the char is a digit/number (0-9), if so, whether it is greater than the base (the number of allowed symbols always has to be less than the base)
			if (Character.isDigit(chDigit) && chDigit - '0' >= theInitialBase) {
				System.out.println("Error, cannot have digit " + chDigit + " in base " + theInitialBase); 
				status = false; // changes the status value that will be returned
				break; // break out of the loop to return the status of theValue String
			}
			
			// If the character is a letter (A-Z), calculate its numerical value by subtracting 'A' then add 10 to adjust it to its numeric value.
			// Check if this value is greater than or equal to the base, as the number of valid symbols in a base must be less than the base itself.

			else if (Character.isLetter(chDigit) && (chDigit - 'A') + 10 >= theInitialBase) {
				System.out.println("Error, cannot have digit " + chDigit + " in base " + theInitialBase);
				status = false;
				break;
			}
			
			// checks for if the char is a special character which is not allowed in the value (must be made of either digits or characters)
			else if (!Character.isDigit(chDigit) && !Character.isLetter(chDigit)) {
				System.out.println("Error, cannot have digit " + chDigit + " in base " + theInitialBase);
				status = false;
				break;
			}
			
		}
		
		return status;
	}
	
	public static String convertInteger(String theValue, int theInitialBase, int theFinalBase) {
		
		BigInteger valueDecimal = new BigInteger("0"); // creating an object of the BigInteger class and assigning it the value of 0
		int temp = 0; // temporary variable to store modulus values when converting from decimal to final base
		String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //All characters possible for up to base 36
		String convertValue = ""; // variable that will return final String after base conversion
		
		//convert to decimal/base 10 firstly, formula: valueOfDigit * (theInitialBase) ^ placeValue) 
		for (int i = 0 ; i < theValue.length(); i++) {
			valueDecimal = valueDecimal.add(BigInteger.valueOf(symbols.indexOf(theValue.charAt(i))).multiply(BigInteger.valueOf(theInitialBase).pow(theValue.length()-(i+1)))) ;
		} 
		
		// the number of symbols of a given base is one less than the base's value
		// starting from the left, convert each digit/character to its correct decimal value based on its position 
		// leftmost bit is multiplied by the initial base,  raised to the length of theValue String minus the current index (which is incremented after every iteration)
		// to simulate the current weight (tens, hundreds, etc) of the bit as we go left to right
		
		//convert to theFinalBase
		while (valueDecimal != BigInteger.valueOf(0)){ // Repeatedly divide the decimal value by the final base
			temp = valueDecimal.mod(BigInteger.valueOf(theFinalBase)).intValue(); // after every iteration store the remainder of the division in temp (will use to return converted String)
			valueDecimal = valueDecimal.divide(BigInteger.valueOf(theFinalBase)); // update the decimal value after every division to eventually terminate the loop
			convertValue = symbols.charAt(temp) + convertValue; //append the character with index of temp from the String symbols which is used to determine what char11 to append to the front of the String
		}
		
		// return the String
		return convertValue; 
		
	}
	
	

}
