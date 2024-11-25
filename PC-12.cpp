// PC-12.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge 12 = Password Verifier

#include <iostream>
#include <string>
#include <cctype> //isdigit, isupper,islower,ispunct

using namespace std;

bool passwordChecker(string); //will call all functions below
bool hasDigit(string);
bool hasUpper(string);
bool hasLower(string);
bool hasSpecialCharacter(string);
bool hasNoSpace(string);

int main()
{
	//variable to hold the password
	string password;

	//asking input
	cout << "Please create and enter your password: ";
	getline(cin, password);

	bool validity = passwordChecker(password);

	//loop so that user has to keep fixing while false
	while (!validity)
	{
		cout << "\nError, your password does not meet the valid criteria." << endl;
		cout << "Please make sure that your password meets the following criteria: \n";
		cout << "---------------------------------------------------------------\n";
		cout << "The password should be at least six characters long.\n";
		cout << "The password should contain at least one uppercase and at least one lowercase letter.\n";
		cout << "The password should have at least one digit.\n";
		cout << "Must contain a special, non-space/alphanumeric character.\n";
		cout << "No spaces.\n";

		cout << "\nPlease create and enter your password: ";
		getline(cin, password);

		validity = passwordChecker(password);
	}

	cout << "\nPhew that password seemed to work! Good job :)" << endl;

	return 0;
}

bool passwordChecker(string password)
{
	//set status to true, if it is able to get past all the checks which will stop and return false
	//then it can then finally return true
	bool valid = true;

	//checks for length, then call functions

	int size = password.length();

	//min length test
	if (size < 12)
		return false;

	if (!hasDigit(password))
		return false;

	if (!hasUpper(password))
		return false;

	if (!hasLower(password))
		return false;
	
	if (!hasSpecialCharacter(password))
		return false;

	if (!hasNoSpace(password))
		return false;
	
	//if it passed everything, then
	return valid;
}

bool hasDigit(string password)
{
	int size = password.length();
	for (int index = 0; index < size; index++)
	{
		if (isdigit(password[index]))
			return true;
	}
	//if not, then
	return false;

}
bool hasUpper(string password)
{
	int size = password.length();
	for (int index = 0; index < size; index++)
	{
		if (isupper(password[index]))
			return true;
	}
	//if not, then
	return false;
}
bool hasLower(string password)
{
	int size = password.length();
	for (int index = 0; index < size; index++)
	{
		if (islower(password[index]))
			return true;
	}
	//if not, then
	return false;
}
bool hasSpecialCharacter(string password)
{
	int size = password.length();
	for (int index = 0; index < size; index++)
	{
		if (ispunct(password[index]))
			return true;
	}
	//if not, then
	return false;
}
bool hasNoSpace(string password)
{
	int size = password.length();
	for (int index = 0; index < size; index++)
	{
		if (isspace(password[index]))
			return false;
	}
	//if not, then
	return true;
}


/* checklist

The password should be at least TWELVE characters long. 
no space characters
• The password should contain at least one uppercase and at least one lowercase letter. •
The password should have at least one digit.
Write a program that asks for a password then verifies that it meets the stated criteria. 
If it doesn’t, the program should display a message telling the user why.

*/