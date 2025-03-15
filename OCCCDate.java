// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 4 Homework - OCCCDate



//import GregorianCalendar and Calendar to use 

import java.util.GregorianCalendar;
import java.util.Calendar;

public class OCCCDate {

	// private variables
	private int dayOfMonth;
	private int monthOfYear;
	private int year;
	
	//private helper object of type GregorianCalendar
	private GregorianCalendar gc;
	
	// boolean variables
	private boolean dateFormat = FORMAT_US; // default is DATE_FORMAT_US
	private boolean dateStyle = STYLE_NUMBERS; // default is DATE_STYLE_NUMBERS
	private boolean dateDayName = SHOW_DAY_NAME; // default is SHOW_DAY_NAME

	
	// static variables (constants)
	public static final boolean FORMAT_US = true; //true bc of default
	public static final boolean FORMAT_EURO = false;
	public static final boolean STYLE_NUMBERS= true;//default
	public static final boolean STYLE_NAMES = false;
	public static final boolean SHOW_DAY_NAME= true;//default
	public static final boolean HIDE_DAY_NAME = false;
	
	
	//default constructor, use current date and time
	public OCCCDate() {
		// constructor will create a GregorianCalendar object and use that to set the day
		//month and year fields
		
		gc = new GregorianCalendar();
		this.dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		this.monthOfYear = gc.get(Calendar.MONTH) + 1; // adding 1 because the gregorian calendar goes from 0-11, but we want to use 1-12 in OCCCDate
		this.year = gc.get(Calendar.YEAR);
		
	}
	
	public OCCCDate(int day, int month, int year) {
		
		// create a GregorianCalendar object using the data from constructor
		this.dayOfMonth = day;
		this.monthOfYear = month;
		this.year = year;
		
		
		
		//array to hold the max number of days from the months 1-12, January to December, use to check if user inputted an invalid day
		int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int maxDays = monthDays[this.monthOfYear - 1]; //with the index of the user input for month, use it to determine the max number of days in that month, this will return the number of days allowed
		
		//account of leap years: a leap year is divisible by 4 or divisible by 400 (end-of-century years)
		if ((year % 4 == 0) || (year % 400 == 0)) {
			//update the index of February in the array to be 29 instead of 28 in common years
			monthDays[1] = 29;
		}
		
		
		
		//in the cases when a user inputs a day value that is overflowed from the maximum number of days in that month
		//also should handle if user inputs a value of January 365, it should become December 31
		while (this.dayOfMonth > maxDays) {
			
			this.dayOfMonth -= maxDays; //for example: March 32, 2020 should be handled to become April 1, 2020
			
			//account for if this results in a negative day 
			if (this.dayOfMonth <= 0) {
				this.dayOfMonth = maxDays - this.dayOfMonth;
			}
			
			
			this.monthOfYear += 1; // add one to the month
			
			if (this.monthOfYear > 12) {
				this.monthOfYear = 1;
				this.year++; //if exceeds 12, set month back to 1, and add one to the year
			}
			
			
			//update maxDays value accordingly to the new month(s)
			maxDays = monthDays[this.monthOfYear - 1]; //subtract by 1 to adjust for the indexes of the monthDays array
			
		} //exits the while loop once the day does not exceed the maxDays allowed in the month
		
		
		
		
		
		// subtract one from the month for the GregorianCalendar constructor
		//the ordering for gc should be GregorianCalendar(year, month, day)
		gc = new GregorianCalendar(this.year, this.monthOfYear - 1, this.dayOfMonth);
		
		
	}
	
	
	public OCCCDate(GregorianCalendar gc) {

		// extracting from the gc that is passed in this constructor
		this.dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		this.monthOfYear = gc.get(Calendar.MONTH) + 1; // adding 1 because the gregorian calendar goes from 0-11, but we want to use 1-12 in OCCCDate
		this.year = gc.get(Calendar.YEAR);
		
	}
	
	// copy constructor
	public OCCCDate(OCCCDate d) {
		this.dayOfMonth = d.dayOfMonth;
		this.monthOfYear = d.monthOfYear;
		this.year = d.year;
		
		// subtract one from the month for the GregorianCalendar constructor
		gc = new GregorianCalendar(this.year, this.monthOfYear - 1, this.dayOfMonth);
	}
	
	
	
	//getters and setters to access and modify variables/data fields from the main program
	
	// 1, 2, 3…
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	
	// Sunday, Monday, Tuesday.. // GregorianCalender does this
	public String getDayName() {
		//list of all the days
		String possibleDays[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int dayNumber = gc.get(Calendar.DAY_OF_WEEK); // will return the day number
		
		String day = possibleDays[dayNumber - 1];//will have to - 1, since the dayNumber will be from 1-7, however array goes from 0-6
		return day;
	}
	
	// 1, 2, 3…
	public int getMonthNumber() {
		return monthOfYear;
	}
	
	// January, February, March…
	public String getMonthName() {
		//like the getDayName method, create a string array with all the months
		String[] possibleMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		//monthOfYear is the int of the month 1-12 
		String actualMonth = possibleMonths[this.monthOfYear - 1]; //-1 to account for the arrays index
		
		return actualMonth;
	}
	
	// Gregorian year, e.g. 2020
	public int getYear() {
		return year;
	}
	
	
	public void setDateFormat(boolean df) {
		this.dateFormat = df; //update the boolean value
	}
	
	
	public void setStyleFormat(boolean sf) {
		this.dateStyle = sf;
	}
	
	
	public void setDayName(boolean nf) {
		this.dateDayName = nf;
	}
	
	// difference in years between this OCCCDate and now
	public int getDifferenceInYears() {
		//get OCCC year, get current year, subtract current year from the OCCC's getYear
		return getDifferenceInYears(new OCCCDate());
	}
	
	
	// difference in years between this date and d
	//The one with the parameter will do all of the work. The other will just call it (above)
	public int getDifferenceInYears(OCCCDate d) {
		int yearDifference = Math.abs(d.year - this.year); // the year of the passed in OCCCDate object
		return yearDifference;
	}
	
	
	 // compare only day, month, and year
	public boolean equals(OCCCDate dob) {
		if ((this.dayOfMonth == dob.dayOfMonth) && (this.monthOfYear == dob.monthOfYear) && (this.year == dob.year)) {
			return true;
		}
		else {
			return false;
		}
	} // instead of using equalsIgnoreCase like the person class homework, use == since this is the int data type (careful, not = which is the assignment operator, use == which compares them)
	
	
	public String toString() {
		
		// US format mm/dd/yyyy or monthName dd, yyyy

		if (dateFormat == FORMAT_US) { //remember to use == for comparison, = is for assignment
			
			//for numbers
			if (dateStyle == STYLE_NUMBERS) { //default is STYLE_NUMBERS which is true
				
				String numStrUS = (monthOfYear + " / " + dayOfMonth + " / " + year);
				
				//if SHOW_DAY_NAME is set to true then return the String with the day name appended to the beginning of the number string (default)
				if(dateDayName == SHOW_DAY_NAME) {
					numStrUS = getDayName() + ", " + numStrUS;
				}
				
				return numStrUS;
			}
			
			
			//for names
			else { //this means that the date style is is not numbers, meaning STYLE_NAMES
				
				String namesStrUS = (getMonthName() + " " + dayOfMonth + ", " + year);
				
				if (dateDayName == SHOW_DAY_NAME) {
					//modify and add getDayName() to beginning of the String that will be returned
					namesStrUS = getDayName() + ", " + namesStrUS;
				}
				
				return namesStrUS;
			}
		}
		
		
		
	
		
		
		
		

		
		
		// Euro format dd/mm/yyyy or dd monthName yyyy
		
		else if (dateFormat == FORMAT_EURO) { //remember to use == for comparison, = is for assignment
			
			//for numbers
			if (dateStyle == STYLE_NUMBERS) { //default is STYLE_NUMBERS which is true
				
				String numStrEURO = (dayOfMonth + " / " + monthOfYear + " / " + year);
				
				//if SHOW_DAY_NAME is set to true then return the String with the day name appended to the beginning of the number string (default)
				if(dateDayName == SHOW_DAY_NAME) {
					numStrEURO = getDayName() + ", " + numStrEURO;
				}
				
				return numStrEURO;
			}
			
			
			//for names
			else { //this means that the date style is is not numbers, meaning STYLE_NAMES
				
				String numStrEURO = (dayOfMonth + " " + getMonthName() + " " + year);
				
				if (dateDayName == SHOW_DAY_NAME) {
					//modify and add getDayName() to beginning of the String that will be returned
					numStrEURO = getDayName() + ", " + numStrEURO;
				}
				
				return numStrEURO;
			}
		}
		
		
		
		
		
		
       // Return a default or error string if dateFormat is neither FORMAT_US nor FORMAT_EURO
		else {
	        return "Invalid date format";
		}
	
	}
	
	
}
