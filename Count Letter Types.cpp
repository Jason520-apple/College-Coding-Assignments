// Count Letter Types.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
//OCCC Fall 2024

#include <iostream>
#include <string>
#include <cctype> // for isupper()
#include <fstream>

using namespace std;

ifstream inputFile;

int main()
{
	string fileName;
	int counter = 0;
	string tempLine;


	cout << "This program will read the file and count the numebr of upper case letters found.\n";
	cout << "\nPlease enter the name of the file you want: ";
	getline(cin, fileName);

	inputFile.open(fileName);

	// Check if the file opened successfully
	while (!inputFile)
	{
		cout << "\nError opening the file!" << endl;
		cout << "\nPlease enter the name of the file you want: ";
		getline(cin, fileName);
		inputFile.open(fileName);

	}

	while (getline (inputFile, tempLine))
	{
		for (int index = 0; index < tempLine.length(); index++)
		{
			if (isupper(tempLine[index]))
			counter++;

		}
	}

	cout << "The number of upper case letters found is: " << counter << endl;

	inputFile.close();

	return 0;
}

/*pseudocode
* program will ask for the name of a file, count the number of upper case 
* 

*/