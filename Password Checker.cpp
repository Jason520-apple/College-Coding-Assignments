// Password Checker.cpp : This file contains the 'main' function. Program execution begins and ends there.
//Jason Vo
// OCCC Fall 2024

#include <iostream>
#include <string>
#include <fstream>
#include <cctype>

using namespace std;

bool isValidPassword(string);

//input object
ifstream inputFile;

//functions, may not need


int main()
{
	string fileName;
	string password;
	int validCount = 0;
	int invalidCount = 0;

	cout << "Name of file: ";
	getline(cin, fileName);

	inputFile.open(fileName);

	while (!inputFile) //input validation
	{
		cout << "Not valid: ";
		getline(cin, fileName);

		inputFile.open(fileName);
	}

	//now check
	while (getline(inputFile, password))
	{
		if (isValidPassword(password))
			validCount++;
		
		else
		{
			//if not, then
			invalidCount++;
		}
	}

	inputFile.close();

	cout << "Valid count: " << validCount << endl;
	cout << "Invalid count: " << invalidCount << endl;

	return 0;
}

bool isValidPassword(string password)
{
	bool valid = false;

	bool upperStatus = false;
	bool lowerStatus = false;
	bool digitStatus = false;
	bool punctStatus = false;
	bool spaceStatus = false;

	//call functions
	if (password.length() < 12)
		return false;

	else
	{
		for (int index = 0; index < password.length(); index++)
		{
			if (isupper(password[index]))
				upperStatus = true;
		}
		for (int index = 0; index < password.length(); index++)
		{
			if (islower(password[index]))
				lowerStatus = true;
		}
		for (int index = 0; index < password.length(); index++)
		{
			if (isdigit(password[index]))
				digitStatus = true;
		}
		for (int index = 0; index < password.length(); index++)
		{
			if (ispunct(password[index]))
				punctStatus = true;
		}
		for (int index = 0; index < password.length(); index++)
		{
			if (isspace(password[index]))
				spaceStatus = true; //that means a space exists
		}

		//check all now for status
		if (upperStatus == true && lowerStatus == true && digitStatus == true && punctStatus == true && spaceStatus == false)
			valid = true;

	}
	return valid;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
