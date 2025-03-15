// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 3 Homework - Recursion

// A BigInteger Factorial program that accepts one parameter on the command line (the integer for which the factorial is to be computed)
// and produces the factorial and the number of digits in that factorial.

import java.math.BigInteger;
import java.util.Scanner;

public class BigInteger_Factorial {

	public static void main(String[] args) {

		// scanner
		Scanner input = new Scanner(System.in);
		
		// variable to store the int for which factorial is to be computed
		int number = 0;

		// command line
		if (args.length == 1) {
			number = Integer.parseInt(args[0]);
		}
		
		// user input
		else if (args.length == 0) {
			System.out.println("Please enter a number. This program will compute its factorial value: \n");
			number = input.nextInt();
			System.out.println();
		}
		
		else {
			System.out.println("Invalid command line parameters, please enter only one number.");
			System.exit(0);
		}
		
		
		
		// timer code
		long t1 = System.currentTimeMillis();
		// calling the factorial with a loop
		System.out.println(number + "! = " + bigIntfactorial_loop(number));
		long t2 = System.currentTimeMillis();
	    System.out.println("\nThe elapsed time for the FACTORIAL LOOP is " + ( t2 - t1 ) / 1000.  + " seconds.\n");
	    
	    // print the number of digits in the loop value
	    String stringValue = bigIntfactorial_loop(number).toString();
	    int length = stringValue.length();
	    System.out.println("\nNumber of digits in this value: " + length);
	    System.out.println();
	    

	    
	    
	    // timer code
	 	long t3 = System.currentTimeMillis();
	 	// calling the factorial with a loop
	 	System.out.println(number + "! = " + bigIntfactorial_recursion(number));
	 	long t4 = System.currentTimeMillis();
	 	System.out.println("\nThe elapsed time for the FACTORIAL RECURSION is " + ( t4 - t3 ) / 1000.  + " seconds.\n");


	}

	
	// BigInteger factorial methods
	// create BigInteger variable to store the integer for which the factorial is to be computed

	public static BigInteger bigIntfactorial_loop(int number) {
		if (number == 0) {
			int a = 1;
			BigInteger result = BigInteger.valueOf(a);

			return result;
		}
		
		BigInteger result = BigInteger.valueOf(number);
		
		for (int i = (number - 1) ; i > 0 ; i--) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		

		return result;
	}
	
	
	public static BigInteger bigIntfactorial_recursion(int number) {
		int a = 1;
		BigInteger result = BigInteger.valueOf(number);
		
		if (number > 1) {
			result = result.multiply(bigIntfactorial_recursion(number-1));
		}
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// long factorial loop and recursion methods below:
	// factorials work by multiplying the number then decrementing by 1 but stopping before 0
	public static long factorial_loop(int n) {
		
		if (n == 0) {
			int value = 1;
			return value;
		}
		long returnValue = n;
		
		for (int i = (n-1) ; i > 0 ; i--) {
			int a = i;
			returnValue *= a;
		}
		return returnValue;
	}
	
	public static long factorial_recursion(int n) {
		
		    long result = 1;
		    if (n > 1){
		      result = n * factorial_recursion(n-1);
		    }
		    return result;
		  
	}
	
	
}



