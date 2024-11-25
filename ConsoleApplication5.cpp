// PC8-11.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 11 - String Selection Sort Modification

//This program has been modified for ints, Sort A List Of Integers is the assignment

#include <iostream>
#include <string>
#include <fstream>

using namespace std;

//functions
void selectionSort(int[], int);
void swap(int&, int&);
void fileNametoArray(int[], int);
void unsortedDisplayArray(int[], int);
void sortedDisplayArray(int[], int);
void returnIndexValue(int[], int);


//inputFile
ifstream inputFile;

int main()
{
	const int FILE_SIZE = 100000;
	int names[FILE_SIZE];


	//first read the names from the file, display unsorted
	fileNametoArray(names, FILE_SIZE);

	//with the array now filled, display them
	unsortedDisplayArray(names, FILE_SIZE);

	//then, call selectionSort to sort the array
	selectionSort(names, FILE_SIZE);

	//then display the names sorted
	sortedDisplayArray(names, FILE_SIZE);

	int index; 

	//prompt the user for an index
	returnIndexValue(names, FILE_SIZE);
	

	return 0;
}

void fileNametoArray(int namesArr[], int sizeOfArray)
{
	string fileName;
	int index = 0;//counter to be incremented
	int tempName; //stores a name to be placed into the array

	//ask for filename, then use a while loop to read the names into the array
	cout << "Please enter the name of the file: " << endl;
	cin >> fileName;

	while (!inputFile)
	{
		cout << "Invalid file name, try again\n";
		cin >> fileName;
	}

	inputFile.open(fileName);

	//getline to ignore spaces and get whole line
	while (index < sizeOfArray && inputFile >> tempName)
	{
		namesArr[index] = tempName;
		index++;
	}
}

void unsortedDisplayArray(int namesArr[], int sizeOfArray)
{
	//Display both the unsorted and sorted names, one name per line.
	cout << "\nThese are the names read from the file, unsorted: " << endl;
	cout << "--------------------------------------------------\n";

	//for loop
	for (int index = 0; index < sizeOfArray; index++)
	{
		cout << namesArr[index] << endl;
	}

}

void sortedDisplayArray(int namesArr[], int sizeOfArray)
{
	//Display both the unsorted and sorted names, one name per line.
	cout << "\nThese are the numbers read from the file, sorted: " << endl;
	cout << "--------------------------------------------------\n";

	//for loop
	for (int index = 0; index < sizeOfArray; index++)
	{
		cout << namesArr[index] << endl;
	}

}

void selectionSort(int namesArr[], int sizeOfArray)
{
	//sorting in ascending order, strings sorted may contain spaces
	int minValue;
	int minIndex;

	//start from the beginning of array, as first element in array is possibly updated
	//then skip over the first element, redo loop, then skip over second, etc
	for (int start = 0; start < sizeOfArray - 1; start++)
	{
		minIndex = start;
		minValue = namesArr[start];

		//
		for (int index = start + 1; index < sizeOfArray; index++)
		{
			if (namesArr[index] < minValue)
			{
				minValue = namesArr[index];
				minIndex = index;
			}
		}
		//swap function will be called at the end of the function
		swap(namesArr[minIndex], namesArr[start]);
	}
}

void swap(int& a, int& b)
{
	int temporary = a;
	a = b;
	b = temporary;
}

void returnIndexValue(int numsArr[], int size)
{
	int index;
	cout << "\nEnter an index, I will display the integer at that index: ";
	cin >> index;

	cout << numsArr[index];
}