// Name: Jason Vo
// Date: 10/19/24
// File: Assignment 1 - Tip Computation
// Description: Tip calculator program that prompts user for subtotal
// tip amount (percentage), variable for grand total and tip amount

package TipComputation;

import java.util.Scanner;

public class TipComputation {

	public static void main(String[] args) {
		
		//scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.println("Thank you for your business!");
		
		//asking for subtotal
		System.out.println("Please enter your subtotal: ");
		double subtotal = input.nextDouble();
		
		//asking for tip percentage
		System.out.println("Please enter the tip percentage (without the percentage sign): ");
		double percentageForTip = input.nextInt();
		double tipPercentage = percentageForTip / 100;
		
		//perform calculations for the dollarAmountofTip, multiply subtotal by tipPercentage
		double dollarAmountForTip = (subtotal * tipPercentage);
		
		//grand total
		double grandTotal = subtotal + dollarAmountForTip;
		
		//display final bill
		System.out.println("-----Final Bill-----");
		System.out.println("--------------------");
		System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Tip: $%.2f\n", dollarAmountForTip);
        System.out.println("--------------------");
        System.out.printf("Grand Total: $%.2f\n", grandTotal);

        // %.2f is the placeholder that formats the value stored in teh double variables of subtotal, dollarAmountForTip, and grandTotal
        // must use printf when using above method of setting precision

	}

}
