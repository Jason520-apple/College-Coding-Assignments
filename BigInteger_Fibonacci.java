// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 3 Homework - Recursion

/*
 * A BigInteger Fibonacci program that accepts one parameter on the command line (the rank of the Fibonacci number to be computed)
 *  and produces that Fibonacci number and the number of digits in that Fibonacci Number. Hint - recursion crashes with a stack 
 *  overflow on relatively small Fibonacci numbers, so compute use a loop.
 *  
 *  Used this yt video for help: https://www.youtube.com/watch?v=cum3OrpURzc
 */


// to calculate fib number: f(n) = f(n-1) + f(n-2)


import java.math.BigInteger;
import java.util.Scanner;

public class BigInteger_Fibonacci {

	// Memoization for type long
	private static long[] fibonacciCache;

	
	public static void main(String[] args) {

		// scanner
		Scanner input = new Scanner(System.in);
		
		// variable that will hold rank of fib number
		int value = 0;
		
		//command line
		if (args.length == 1) {
			value = Integer.parseInt(args[0]);
		}
		
		//user input
		else if (args.length == 0) {
			System.out.println("This program will calculate the Fibonacci number of an nth number. Please enter a number: ");
			value = input.nextInt();
		}
		else {
			System.out.println("Invalid use: please enter only one number of type int.");
			System.exit(0);
		}
		
		
		// Memoization for long array, will need to be one size larger than the value, since the first and second value are 0 and 1
		// note, do not need to pass in since declared outside of the main method
		fibonacciCache = new long[value + 1];
		
		
		
		
		
		
		// calling the BigInteger Fib methods, include timer code
		
		// timer code
		long t1 = System.currentTimeMillis();

		System.out.println("The " + value + "th fibonacci number using a loop is: " + bigIntFibLoop(value));
		
		long t2 = System.currentTimeMillis();
		
		System.out.println("\nThe elapsed time for the FIBONACCI LOOP is " + ( t2 - t1 ) / 1000.  + " seconds.\n");
			    
		
		
		// print the number of digits in the loop value
	    String stringValue = bigIntFibLoop(value).toString();
	    int length = stringValue.length();
	    System.out.println("\nNumber of digits in this value: " + length);
	    System.out.println();
		
		
		
		
		// Memoization for BIGINTEGER FIB RECURSION, create array of BigInt, will need to pass in
		BigInteger[] memo = new BigInteger[value + 1];
		
		long t3 = System.currentTimeMillis();

		System.out.println("The " + value + "th fibonacci number using recursion is: " + bigIntFibRecursion(value, memo));
		
		long t4 = System.currentTimeMillis();
		
		System.out.println("\nThe elapsed time for the FIBONACCI RECURSION is " + ( t4 - t3 ) / 1000.  + " seconds.\n");

		
		
		
		
		
		
	}
	
	// BigInteger versions of loop and recursion below
	
	// received help from: https://www.geeksforgeeks.org/large-fibonacci-numbers-java/
	public static BigInteger bigIntFibLoop (int number) {
		
		// if 0
		if (number == 0) {
			BigInteger result = BigInteger.valueOf(0);
			return result;
		}
		
		// if 1
		if (number == 1) {
			BigInteger result = BigInteger.valueOf(1);
			return result;
		}
		
		// create values of type BigInteger: b will act as the accumulator that will be the returned value
		BigInteger a = BigInteger.valueOf(0); // first value of fib sequence is 0, will hold the (n-2)
        BigInteger b = BigInteger.valueOf(1); // second value is 1, will be updated (n-1)
        BigInteger temp = BigInteger.valueOf(1); // c will act as a temporary variable that will be used to update b each run
        
        // for loop to iterate until the nth number
        for (int i = 2 ; i <= number ; i++) { 
            temp = a.add(b); // add 
            a = b; 
            b = temp; 
        }
        
        return b;
		
		
	}
	
	
	
	public static BigInteger bigIntFibRecursion (int number, BigInteger[] memo) {
		
		
		// Base case for the first 2 values, 0 and 1
		// if 0
		if (number == 0) {
			BigInteger result = BigInteger.valueOf(0);
			return result;
		}
				
		// if 1
		if (number == 1) {
			BigInteger result = BigInteger.valueOf(1);
			return result;
		}
				
		
		
		// Recursive case occurs only when n >= 2
		
		// initialize variable that will be returned
		BigInteger nthFibonacciNumber = BigInteger.valueOf(0);

		
		// checking if we already have stored/calculated the value of that number
		// if a there is a value for that index, return to be used for memoization
		if (memo[number] != null) {
			return memo[number];
		}
				
				
		// fib number algorithm, call the function itself to add the (n-1) and (n-2) recursively until "number" variable reaches base case, then it unwinds and ends
		nthFibonacciNumber = bigIntFibRecursion(number - 1, memo).add(bigIntFibRecursion(number - 2, memo));
		
		// store this value in the fibonacci cache/array for memoization/optimization purposes
		memo[number] = nthFibonacciNumber;
				
				
		return nthFibonacciNumber;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// unused algorithms that were used earlier to find values that required long data type
	
	
	
	// Fib loop
	public static long fibonacci_loop (int number) {
		
		// check if user input 0 or 1, if so return
		if (number <= 1) {
			return number;
		}
		
		long result = 1;
		    if (number > 2) {
		       long a = 1;
		       long b = 1;
		       
		       for (int count = 3; count <= number; count++){
		         result = a + b;
		         a = b;
		         b = result;
		       }
		    }
		 return result;
		  
	}
	
	
	// Fib recursion
	public static long fibonacci_recursion (int number) {
		
		// Base case for the first 2 values, 0 and 1
		if (number <= 1) {
			return number;
		}
		
		
		// checking if we already have stored/calculated the value of that number
		if (fibonacciCache[number] != 0) {
			return fibonacciCache[number];
		}
		
		
		// fib number algorithm
		long nthFibonacciNumber = fibonacci_recursion(number - 1) + fibonacci_recursion(number - 2);
		
		// store this value in the fibonacci cache for memoization/optimization purposes
		fibonacciCache[number] = nthFibonacciNumber;
		
		
		return nthFibonacciNumber;
		
	}
	
	

}
