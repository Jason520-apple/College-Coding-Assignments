// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 2 Homework - Sort and Merge

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;



//file 1: D:\file1.txt
//file 2: D:\file2.txt

// Implemented binary merge sort

public class SortMerge {

	public static void main(String[] args) {

		// Scanner input for file names
		Scanner input = new Scanner(System.in);
		
		// Variables to store file names that wish to be sorted
		String file1 = "";
		String file2 = "";
		
		// Variable to store a file name that will be used to create a file and dump the merged list
		String dumpFile = "";
		
		// If there are no command line parameters, then user input
		if (args.length == 0) {
			// Greeting
			System.out.println("Hello, this program will sort and merge two files.\nPlease enter the first file name: ");
			file1 = input.nextLine();
			
			System.out.println("Please enter the second file name: ");
			file2 = input.nextLine();
			
			System.out.println("Please enter the desired name for a file that will store the sorted and merged numbers: ");
			dumpFile = input.nextLine();
			
			
			
			
		}
		
		// checking command line for three parameters
		else if (args.length == 3) {
			file1 = args[0];
			file2 = args[1];
			dumpFile = args[2];
		}
		
		else {
			// Error message
			System.out.println("Usage: Sort and Merge [initialValue initialBase finalBase]");
			System.exit(0);
			
		}
		
		// Try block to open files, catch block for errors
		
		try {
			
			// Open and read file 1
			File myFile = new File(file1);
			Scanner myReader = new Scanner (myFile);
			
			// Reading the first int as the size of the array
			int size1 = myReader.nextInt();
			
			// Creating an array with this value
			int [] fileArray1 = new int[size1];
			
			// Using a for loop to fill the array
			for (int index = 0 ; index < size1 ; index++) {
				
				fileArray1[index] = myReader.nextInt();
				
			}
			
			
			// Open and read file 2
			File myFile2 = new File(file2);
			Scanner myReader2 = new Scanner (myFile2);
			
			// Reading the first int as the size of the array
			int size2 = myReader2.nextInt();
						
			// Creating another array with this value
			int [] fileArray2 = new int[size2];
						
			// Using a for loop to fill the array
			for (int index = 0 ; index < size2 ; index++) {
							
				fileArray2[index] = myReader2.nextInt();
							
			}
			
			// Tried to implement natural merge sort but was unsuccessful, so used binary merge sort instead:
			// Received help from this video: https://www.youtube.com/watch?v=3j0SWDX4AtU&t=68s
			
			mergeSort(fileArray1); //sort fileArray1
			mergeSort(fileArray2); //sort fileArray2
			
			
			
			
			
			// Next, merge the two fileArrays into the combinedArray
			int combinedSize = size1 + size2;
			int [] combinedArray = new int[combinedSize];
			
			
			// passing in the sorted fileArrays along with combinedArray into the merge method
			// combinedArray will be the fully sorted array and will be outputted to a file
			merge(fileArray1, fileArray2, combinedArray);
			
			
			
			// Create a file with the input of dumpFile, will contain the combinedArray
			// Received help on file output from: https://www.youtube.com/watch?v=ScUJx4aWRi0
			
			try {

				// Create writer that will create and write to a file with the name of the dumpFile
				BufferedWriter writer = new BufferedWriter(new FileWriter(dumpFile));
				
				
				// Print the number of integers that is in the array
				writer.write(combinedSize + "\n");
				
				
				
				// Using a for loop to read through the array and write to the file
				for (int i = 0 ; i < combinedArray.length ; i++) {
					writer.write(combinedArray[i] + " "); //blank space for clarity
				}
				
				// close writer
				writer.close();

				System.out.println("\nArray successfully printed to new file named " + dumpFile);

			}
			
			//if the user enters an invalid output file name
			catch (IOException e) {
				System.out.println("\nError, unable to create file using specified file name: " + dumpFile);
				e.printStackTrace();
				System.exit(0);
			}			
			
			
			System.out.println();
			System.out.println();
			System.out.println();

			// Display the first 100 and last 100 numbers of the array to the user (end of program)
			System.out.println("Printing first 100 and last 100 numbers: ");
			displayArray(combinedArray);
			
		System.out.println("\n\nProgram has finished running! :)");
			
			
		}
		
		// if the files are unable to be opened
		catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.toString());
			System.exit(0);
		}
		
		input.close();
		
		
		
}

	
	// In mergeSort, according to the video, the leftArray is sorted first, then the rightArray
	// Also, the values are then compared with each other and then replace the original arrays in order from least to greatest
	
	// The goal of merge sort is to recursively divide array in 2, sort, then re-combine
	// Run-time complexity = O(n Log n), Space complexity = O(n)
	
	private static void mergeSort(int[] fileArray) {
		
		// Get length of array
		int length = fileArray.length;
		
		// Base case when to stop recursion
		if (length <= 1) {
			return; // if array is equal to one, then the array has already been divided as much as possible, so stop recursion
		}
		
		// Find middle position of array
		int middle = length / 2;
		int[] leftArray = new int[middle]; // declaring the left and right arrays, there sizes will be equal to half of the length of the original array (whole)
		int[] rightArray = new int[length - middle];
		
		
		
		// Copy elements of original array into left and right arrays
		
		int i = 0; //left array index
		int j = 0; //right array index
		
		// For loop to copy
		for (; i < length ; i++) {
			
			if (i < middle) {
				leftArray[i] = fileArray[i]; // copy element from fileArray to the leftArray
			}
			else {
				rightArray[j] = fileArray[i]; // copy to right
				j++; // increment j if it is 
			}
			
		}
		
		
		// Using recursion, call mergeSort and passing in leftArray
		mergeSort(leftArray);
		
		// Then pass in rightArray
		mergeSort(rightArray);
		
		// Then merge the two arrays together
		merge(leftArray, rightArray, fileArray);
		
	}
	
	
	// This will merge two sorted arrays together
	// Note: will have to call this as well to merge the fileArray1 and fileArray2 back together
	private static void merge (int[] leftArray, int[] rightArray, int[] array) {
		
		// listing sizes of the arrays
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		
		
		// indices
		int i = 0; // large array
		int l = 0; // left array
		int r = 0; // right array
		
		// plan: create a while loop that compares the int value at a particular index in leftArray and rightArray
		// if one is less than the other than place that value at the index in the original/large array that will be printed
		//else, compare the one that was bigger with the next value, incrementing indices accordingly
		
		
		// while the left and right arrays still have values in them
		while (l < leftSize && r < rightSize) {
			
			if (leftArray[l] < rightArray[r]) {
				//then copy element to big original array
				array[i] = leftArray[l];
				i++;
				l++;
			}
			
			// if not smaller, then copy right
			else {
				array[i] = rightArray[r];
				i++;
				r++;
			}
			
		}
		
		
		// While loops for if there is only one element left which can't be compared to anything else
		while (l < leftSize) {
			array[i] = leftArray[l];
			i++;
			l++;
		}
		
		while (r < rightSize) {
			array[i] = rightArray[r];
			i++;
			r++;
		}
		
		
		
		
	}
	
	
	
	//displayArray method
	private static void displayArray(int[] array) {
		
		// will only show first and last 100 integers
		
		// this is the first 100
		for (int i = 0 ; i < 100 ; i++) {
			// every 10 integers create newline character
			if (i % 10 == 0) {
                System.out.println();
			}
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		// this is the last 100
		for (int j = (array.length - 100) ; j < array.length ; j++) {
			if (j % 10 == 0) {
                System.out.println();
			}
            System.out.print(array[j] + " ");
		}
		
				
	
	}
		
		
		
}

