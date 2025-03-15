// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 4 Homework - OCCCDate

import java.util.Scanner;

public class TestOCCCDate {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		// Enter today's date, then create and display the corresponding OCCCDate. Set the format of this OCCCDate to numeric, US. Also display the name of the day of the week.
		System.out.println("Welcome to the OCCCDate program. Please enter today's date, this program will display the correspoining OCCCDate (format: [day month year]): \n");
		int todayDay = input.nextInt();
		int todayMonth = input.nextInt();
		int todayYear = input.nextInt();
		
		
		//creating OCCCDate object, using parameterized constructor
		OCCCDate todayDate = new OCCCDate(todayDay, todayMonth, todayYear);
		
		//from ppt, use the setters, then the constants provided within the class to set format, style, and whether to show or hide day name
		todayDate.setDateFormat(OCCCDate.FORMAT_US);
		todayDate.setStyleFormat(OCCCDate.STYLE_NUMBERS);
		todayDate.setDayName(OCCCDate.SHOW_DAY_NAME);

		
		//print out todayDate object
		System.out.println();
		System.out.println(todayDate);
		
		
		// Enter and display an OCCCDate created from February 29, 2022 (should display as March 1, 2022). Set the format of this OCCCDate to numeric, European. 
		// Also display the name of the day of the week.
		System.out.println("\nPlease enter the date for February 29, 2022 for testing purposes (there were only 28 days in February 2022)! Note the format: [29 2 2022]\n");
		int euroDay = input.nextInt();
		int euroMonth = input.nextInt();
		int euroYear = input.nextInt();
		
		//creating OCCCDate object
		OCCCDate euroDate = new OCCCDate(euroDay, euroMonth, euroYear);
		
		//setting the format to numeric, European, display the name of the day of the week
		euroDate.setDateFormat(OCCCDate.FORMAT_EURO);
		euroDate.setStyleFormat(OCCCDate.STYLE_NUMBERS);
		euroDate.setDayName(OCCCDate.SHOW_DAY_NAME);
		
		
		//display
		System.out.println();
		System.out.println(euroDate);
		
		
		
		
		// Enter and display an OCCCDate created from January 365, 2022 (should display as December 31). Format: names, US. Also display the name of the day of the week.
		System.out.println("\nNow try to enter the date for January 365, 2022. Enter as [365 1 2022]: \n");
		int testDay = input.nextInt();
		int testMonth = input.nextInt();
		int testYear = input.nextInt();
		
		
		OCCCDate testDate = new OCCCDate(testDay, testMonth, testYear);
		
		testDate.setDateFormat(OCCCDate.FORMAT_US);
		testDate.setStyleFormat(OCCCDate.STYLE_NAMES);
		testDate.setDayName(OCCCDate.SHOW_DAY_NAME);
		
		
		System.out.println();
		System.out.println(testDate);
		
		
		// James T. Kirk will be born on March 22, 2233. Enter and create that OCCCDate; format as names, European. Also display the name of the day of the week.
		System.out.println("\nJames T. Kirk will be born on March 22, 2233, enter [22 3 2233]: \n");
		int starTrekDay = input.nextInt();
		int starTrekMonth = input.nextInt();
		int starTrekYear = input.nextInt();
		
		
		OCCCDate starTrekDate = new OCCCDate(starTrekDay, starTrekMonth, starTrekYear);
		
		starTrekDate.setDateFormat(OCCCDate.FORMAT_EURO);
		starTrekDate.setStyleFormat(OCCCDate.STYLE_NAMES);
		starTrekDate.setDayName(OCCCDate.SHOW_DAY_NAME);
		
		
		System.out.println();
		System.out.println(starTrekDate);
		
		
		System.out.println("\nProgram has finished running :)");
		
		input.close();
		
	}

}
