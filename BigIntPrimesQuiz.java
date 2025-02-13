import java.util.Scanner;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.io.File;

// path of the file: C:\Users\ancom\Downloads\BigIntPrimes.txt

public class BigIntPrimesQuiz {

	public static void main(String[] args) {

		// User input
		System.out.println("Enter file name: ");
		Scanner input = new Scanner (System.in);
		
		String fileName = input.nextLine();
		
		// counter
		int validCount = 0;
		
		
		// Try/catch block
		try {
			
			// open file then read it
			File myFile = new File(fileName);
			
			// will use to read each new line in myFile, the file that was opened
			Scanner reader = new Scanner(myFile);
			
			// while loop to run through the file until there are no lines left
			
			while (reader.hasNextLine()) {
				
				// call the prime function loop, passing in bigInt
				
				// creating the BigInteger
		        BigInteger bigInt = new BigInteger(reader.nextLine());
				
				
				if (isPrimeNumber(bigInt)) {
					
					System.out.println();
					System.out.println(bigInt + " is valid");
					System.out.println();

					
					validCount++;
				}
				
			}
			
			System.out.println();
			System.out.println("The number of valid BigInt prime numbers: " + validCount);
			System.out.println();

		}
		catch (FileNotFoundException fnfe) {
			
			System.out.println("File not found :(");
			System.exit(0);
			
		}
		
	}
	
	
	
	// Function to check if a number is prime
    public static boolean isPrimeNumber(BigInteger number) {
    	
    	// Check if the number is prime
    	
        int certainty = 100; // High certainty
        boolean isPrime = number.isProbablePrime(certainty);
        
        if (isPrime) {
        	return true;
        }
        
        else {
        	return false;
        }
	

}
	

}
