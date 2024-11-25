// Search A Word List.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

void randomWordsList(string[], int);
void selectionSort(string[], int);
void swap(string&, string&);

ifstream inputFile;
ifstream inputFile2;


int main()
{
	const int tenThousandRandomWordsSize = 10000;
	string arr[tenThousandRandomWordsSize];

	randomWordsList(arr, tenThousandRandomWordsSize);

	selectionSort(arr, tenThousandRandomWordsSize);
	
	//read second file, don't use an array, process words as they are read
	//vector
	string fileName;
	

	cout << "Enter the name of the 2nd file for Search Words: ";
	getline(cin, fileName);

	inputFile2.open(fileName);

	while (!inputFile2)
	{
		cout << "\nTry again: ";
		getline(cin, fileName);
	}

	int counter = 0;
	string tempString;
	while (getline (inputFile2, tempString))
	{
		//get the value, if same, then increment
		//this is linear search, but i should try binary to learn
		for (int index = 0; index < tenThousandRandomWordsSize; index++)
		{
			if (arr[index] == tempString)
			{
				counter++;
			}
		}
	}

	inputFile2.close();

	cout << "\nThe number of words found that were the same is: " << counter << endl;

	return 0;
}

void randomWordsList(string arr[], int size)
{
	string nameOfFile;
	int index = 0;
	string placeHolder;

	//prompt for a file name
	cout << "Please enter the name of the file for 10,000 random words: ";
	getline(cin, nameOfFile);

	inputFile.open(nameOfFile);

	while (!inputFile)
	{
		cout << "\nInvalid \n";
		getline(cin, nameOfFile);
	}

	//reading, use getline
	while (index < size && getline(inputFile, placeHolder))
	{
		arr[index] = placeHolder;
		index++;
	}
	inputFile.close(); // Close the first file

}

//selectionsort
void selectionSort(string array[], int size) 
{
	int minIndex;
	string minValue;

	for (int start = 0; start < size - 1; start++) 
	{
		minIndex = start; // Assume the first element is the minimum
		minValue = array[start];

		// Find the index of the minimum element in the remaining unsorted array
		for (int index = start + 1; index < size; index++)
		{
			if (array[index] < minValue)
			{
				minValue = array[index];
				minIndex = index; // Update minIndex if a new minimum is found
			}
		}

		// Swap the found minimum element with the first element of the unsorted array
		swap(array[minIndex], array[start]);
	}
}

void swap(string& a, string& b)
{
	string temp = a;
	a = b;
	b = temp;
}