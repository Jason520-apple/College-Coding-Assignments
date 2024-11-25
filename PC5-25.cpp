// PC5-25.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 25 - Student Line Up Using Files

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
	//open file
	ifstream inputFile;
	string name;
	string fileName;
	string firstName;
	string lastName;

	cout << "Please enter the name of the file exactly as written: " << endl;
	cin >> fileName;

	inputFile.open(fileName);

	if (inputFile)
	{
		cout << "Reading data from the file.\n";

		firstName = "";
		lastName = "";

		//read to and compare lines of names, then replace each other if names are lower or higher on alphabet
		while (getline(inputFile, name))
		{
			if (firstName.empty())
			{
				firstName = name;
				lastName = name;
			}

			else
			{
				if (name < firstName)
					firstName = name;
				if (name > lastName)
					lastName = name;
			}
		}

		inputFile >> name;
		cout << "First is " << firstName << " , " << "last is " << lastName << endl;

		inputFile.close();
	}

	else
	{
		cout << "Invalid file name, error occurred" << endl;
	}

	return 0;


}

/*Pseudocode
* we are reading data from a file so: ifstream
* input file, then 
*/