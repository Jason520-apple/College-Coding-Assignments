// PC6-23.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
//Programming Challenge:  23 - Prime Number List

#include <iostream>
#include <fstream>
#include <string>
#include <cmath>

using namespace std;

bool isPrime(int);

int main()
{
	//variables
	int startRange;
	int endRange;
	int num1, num2;
	string name;


	//prompting user for range
	cout << "Please enter the range of the numbers desired, separated by a space: " << endl;
	cin >> num1 >> num2;

	//assigning range validation
	if (num1 < num2)
	{
		startRange = num1;
		endRange = num2;
	}
	else
	{
		startRange = num2;
		endRange = num1;
	}

	//promt user for desired output file name, ofstream
	cout << "Please enter the desired name for the output file: " << endl;
	cin.ignore(); //have to clear the newline
	getline (cin, name);

	ofstream outputFile;
	outputFile.open(name);

	for (int i = startRange; i <= endRange; i++)
	{
		if (isPrime(i))
			outputFile << i << endl;
	}

	outputFile.close();

	cout << "The prime numbers between " << startRange << " and " << endRange << " have been written to " << name << endl;

}

bool isPrime(int number)
{
	if (number <= 1)
		return false;
	//using a int that increments each loop to determine whehter a number is only diviidsible by itself or not
	//it will keep looping if prime since only diviisble by itself or 1
	for (int a = 2; a < number; a++)
	{
		if (number % a == 0)
			return false;
	}
	
	//after all checks, then must be prime
	return true;
}