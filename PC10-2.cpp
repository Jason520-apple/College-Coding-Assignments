// PC10-2.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 2 - Backwards String

#include <iostream>
#include <string>

using namespace std;

//function prototype
string reverseString(string);

int main()
{
	string str;

	//ask for an input for the string
	cout << "Please enter the string argument that you want to be reversed: ";
	getline(cin, str);

	string newString = reverseString(str);

	cout << "The reversed version of the original string is: " << newString << endl;
	
	return 0;
}

string reverseString(string str)
{
	int size = str.length();

	string reversed = "";

	for (int index = size - 1; index >= 0; index--)
		reversed += str[index];

	return reversed;
}
