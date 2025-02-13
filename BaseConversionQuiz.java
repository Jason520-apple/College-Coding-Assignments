
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class BaseConversionQuiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		
		// fileName path: C:\Users\ancom\Downloads\BaseConversionInput.txt
		System.out.println("Enter file name: ");
		String fileName = input.nextLine();
		
		
		
		
		int counter = 0;
		
		BigInteger totalDecimalValue = new BigInteger("0"); // sum or running total

		
		
		
		// Open by putting the name of the file which was obtained and read/traverse through the file, use a try/catch block to attempt to read a file 
		try {
			File inputFile = new File(fileName);
			Scanner f = new Scanner(inputFile);
			
						
			while(f.hasNextLine()) {
				// While there are contents, assign them to variable, use the isValid method to determine whether valid. If so, then use the base converter
				// to convert from base _ to base 10
				
				String valueToBeConverted = f.next().toUpperCase();
				int base = Integer.parseInt(f.next());
				if (isValidInteger(valueToBeConverted, base)) {
					//convert to decimal
					totalDecimalValue = totalDecimalValue.add(convertInteger (valueToBeConverted, base));	
					counter++;

					
					}
				
				
				System.out.println("The total decimal value of the file is " + totalDecimalValue);
				System.out.println();
				System.out.print("Valid count: " + counter);
				System.out.println();

				
				
			
				}
			
			

			}
				
				
		
				
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe.toString());
			System.exit(0);
		}

				

	}
	
	
	
	
		
		// Used this yt video as help: https://www.youtube.com/watch?v=E1kOFHhNij4	
		public static boolean isValidInteger(String theValue, int theInitialBase) {
			
			
			char chDigit; // temporary variable which will be used to store the letter or digit that will be checked against the conditions below in the for loop
			boolean status = true; // will be used to return status at the end, if it passes all of the conditions in the for loop
			
			for (int i = 0 ; i < theValue.length() ; i++) {
				chDigit = theValue.toUpperCase().charAt(i); // set to uppercase
				
				if (Character.isDigit(chDigit) && chDigit - '0' >= theInitialBase) {
					System.out.println("Error, cannot have digit " + chDigit + " in base " + theInitialBase); 
					status = false; // changes the status value that will be returned
					break;
				}
				
			
				else if (Character.isLetter(chDigit) && (chDigit - 'A') + 10 >= theInitialBase) {
					System.out.println("Error, cannot have digit " + chDigit + " in base " + theInitialBase);
					status = false;
					break;
				}
				
				// checks for if the char is a special character which would not work
				else if (!Character.isDigit(chDigit) && !Character.isLetter(chDigit)) {
					System.out.println("Error, cannot have digit " + chDigit + " in base " + theInitialBase);
					status = false;
					break;
				}
				
			}
			
			return status;
		}
	
	
	
		
		public static BigInteger convertInteger(String theValue, int theInitialBase) {
			 // contract: converts theValue from initialBase to finalBase and returns the
			 // result as a String.
			 // precondition: theValue must be a valid expression in initialBase.
			 // precondition enforced by invoking the function above before conversion
			

			BigInteger valueDecimal = new BigInteger("0"); // creating an object of the BigInteger class and assigning it the value of 0
			int temp = 0; // temporary variable to store modulus values when converting from decimal to final base
			String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //All characters possible for up to base 36
			String convertValue = ""; // variable that will return final String after base conversion
			
			//convert to decimal/base 10 firstly, formula: valueOfDigit * (theInitialBase)^placeValue) 
			for (int i = 0 ; i < theValue.length(); i++) {
				valueDecimal = valueDecimal.add(BigInteger.valueOf(symbols.indexOf(theValue.charAt(i))).multiply(BigInteger.valueOf(theInitialBase).pow(theValue.length()-(i+1)))) ;
			} 
			
			// return the String
			return valueDecimal; 
			
		}
		
		

	}
