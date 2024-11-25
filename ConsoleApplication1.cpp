// ConsoleApplication1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

bool isPrime(int);

int main()
{
	int number;
	int primeNumberCounter = 0;
	string name;
	ifstream inputFile;

	
	inputFile.open("C:\Users\ancom\source\repos\prime numbers\Big List of Random Integers.txt");

	while (inputFile >> number)
	{
		if (isPrime(number))
			primeNumberCounter++;
	}

	inputFile.close();

	cout << "There are " << primeNumberCounter << " prime numbers in the file ";

	return 0;
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