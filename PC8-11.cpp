// PC8-11.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 11 - String Selection Sort Modification

#include <iostream>
#include <string>
#include <fstream>

using namespace std;

//functions
void selectionSort(string[], int);
void swap(string&, string&);
void fileNametoArray(string[], int);
void unsortedDisplayArray(string[], int);
void sortedDisplayArray(string[], int);


//inputFile
ifstream inputFile;

int main()
{
	const int FILE_SIZE = 50;
	string names[FILE_SIZE];


	//first read the names from the file, display unsorted
	fileNametoArray(names, FILE_SIZE);

	//with the array now filled, display them
	unsortedDisplayArray(names, FILE_SIZE);
	
	//then, call selectionSort to sort the array
	selectionSort(names, FILE_SIZE);

	//then display the names sorted
	sortedDisplayArray(names, FILE_SIZE);

	return 0;
}

void fileNametoArray(string namesArr[], int sizeOfArray)
{
	string fileName;
	int index = 0;//counter to be incremented
	string tempName; //stores a name to be placed into the array

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
	while (index < sizeOfArray && getline(inputFile, tempName))
	{
		namesArr[index] = tempName;
		index++;
	}
}

void unsortedDisplayArray(string namesArr[], int sizeOfArray)
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

void sortedDisplayArray(string namesArr[], int sizeOfArray)
{
	//Display both the unsorted and sorted names, one name per line.
	cout << "\nThese are the names read from the file, sorted: " << endl;
	cout << "--------------------------------------------------\n";

	//for loop
	for (int index = 0; index < sizeOfArray; index++)
	{
		cout << namesArr[index] << endl;
	}

}

void selectionSort(string namesArr[], int sizeOfArray)
{
	//sorting in ascending order, strings sorted may contain spaces
	string minValue;
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

void swap(string &a, string &b)
{
	string temporary = a;
	a = b;
	b = temporary;
}