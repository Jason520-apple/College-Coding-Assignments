// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 2 Homework - Puzzle Reader

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;

// Used the textbook as a reference on how to implement and use two dimensional arrays

// File used to check: C:\Users\ancom\Downloads\SquarePuzzle.txt
public class PuzzleReader {

	public static void main(String[] args) {
		
		// Scanner
		Scanner input = new Scanner(System.in);
		
		// Variable to hold file name
		String fileName = "";
		
		// User input
		if (args.length == 0) {
			
			System.out.println("Please enter the name of the file: ");
			fileName = input.nextLine();
			
		}
		
		// Command line parameters
		else if (args.length == 1) {
			fileName = args[0];
		}
		
		// Input validation
		else {
			System.out.println("Please enter only the name of the file: ");
			System.exit(0);
			
		}
		
		
		// Try and catch block for processing file
		try {
			
			// Open file and read from it using a scanner
			File myFile = new File(fileName);
			Scanner myReader = new Scanner(myFile);
			
			// Read the entire file into a vector of characters
			Vector<Character> vector = new Vector<>();
			
			while (myReader.hasNext()) {
				vector.add(myReader.next().charAt(0));
			}
			
			
			// If the number of elements/characters in the vector is a perfect square (can take square root of the vector's size), 
			// create your square table (a two-dimensional array) and copy the values
			// (converting from char to the associated integer value) from the vector into the table, else terminate
			
			// if you can sqrt the square of a vector size and get the same number as its size, it is a perfect square
			// ex: 16: sqrt(16) = 4, 4^2 = 16 . this is equal to the original vector's length of 16
			
			if (Math.pow(Math.sqrt((double) vector.size()), 2) == vector.size()) {
				
				// Since it is a perfect square, the square root of the vector's size is equal to the size of both the rows and columns arrays
				int numRows = (int) Math.sqrt(vector.size());
				int numColumns = numRows; // The number of rows and columns is the same (they are a square)
				
				// Create square table of type char (will contain letters and digits), two dimensional
				char [][] squareTable = new char[numRows][numColumns];
				
				// Variable that will serve as an index/accumulator variable to access elements in vector
				int count = 0;
				
				// Copy values from the vector into the table using a nested for loop
				for (int a = 0 ; a < numRows ; a++) {
					for (int z = 0 ; z < numColumns ; z++) {
						squareTable [a][z] = vector.elementAt(count);
						count++; // Incremented for each iteration
					}
				}
				
				System.out.println("\nPuzzle before conversion: \n");
				
				displayTable(squareTable);
				
				System.out.println();
				System.out.println();
				
/*
 *  * Objective: convert each letter that shows up into its decimal equivalent
 * such as A to 10. This will be achieved by first creating an array or vector of type
 * String, from 0-9, A-Z, then everything will be set to upper case if not already, then
 * the index that the char or digit is found will become the value that is displayed to
 * the user in the new table. These values will replace each of the elements in the 2D array
 * then will call the displayTable method to display at the end of program.
 * Special characters will become blank spaces "". Whatever index it is found at is the number
 * that will replace it within the table.
 */
				
				// All available digits and letters
				String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				
				// Creating a new array to update the values, same size as original
				int numRows2 = numRows;
				int numColumns2 = numColumns;
				
				String [][] solvedTable = new String[numRows2][numColumns2];
				
				// Filling the new table with the contents of solvedTable
				for (int rows = 0 ; rows < numRows2 ; rows++) {
					for (int columns = 0 ; columns < numColumns2 ; columns++) {
						solvedTable[rows][columns] = Character.toString(squareTable[rows][columns]); // copy contents into solvedTable, will replace later
					}
				}
				
				
				
				// now read each of the symbols that is found in each piece of the puzzle, 
				// replace it with the index that the certain char is found. make sure that it is set to upper case firstly
				for (int rows = 0 ; rows < numRows2 ; rows++) {
					for (int columns = 0 ; columns < numColumns2 ; columns++) {
						
						char ch = Character.toUpperCase(squareTable[rows][columns]); // store the character in a variable, set it to upper case if it isn't already
						
						int index = symbols.indexOf(ch); // assign the index where the letter or digit is found
						
						// if the letter/digit is not found, it will return -1 as an error code, so i will use that to construct if/else statement
						if (index != -1) {
							solvedTable[rows][columns] = String.valueOf(index); //store the int as a String
						}
						else {
							solvedTable[rows][columns] = " "; // blank space if it is a special character
						}
						
					}
				}

				// now display the table by calling the displayTable method
				System.out.println("\nPuzzle after conversion:\n");
				displayTable(solvedTable);
				
				System.out.println("\nPuzzle Reader program has finished running!\n");

				myReader.close();
				input.close();
				
			}
			else {
				System.out.println("Error, puzzle entered is not a valid/perfect square.");
				System.exit(0);
			}
			
		}
		catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.toString());
			System.exit(0);
		}

	}

	// Table before conversion of type char
	private static void displayTable(char[][] squareTable) {
				
		for (int row = 0 ; row < squareTable.length ; row++) {
			for (int column = 0 ; column < squareTable.length ; column++) {

				System.out.printf("%3c", squareTable[row][column]);
				
				
			}
			
			System.out.println();
			System.out.println();
		}
		
	}
	
	// Table for after conversion (method overload)
	private static void displayTable(String[][] solvedTable) {
		
		for (int row = 0 ; row < solvedTable.length ; row++) {
			for (int column = 0 ; column < solvedTable.length ; column++) {

				System.out.printf("%3s", solvedTable[row][column]);
				
				
			}
			
			System.out.println();
			System.out.println();
		}
		
	}


}
