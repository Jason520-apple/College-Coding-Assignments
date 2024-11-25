// PC6-8.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 8 - Coin Toss

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int coinToss();

int main()
{
	int times; //this will hold the amount of times the user wants
	int counter; // used to restrict the amount of times looped
	int tailsCount = 0;
	int headsCount = 0;

	//prompt the user for how many times the coin should be tossed
	cout << "How many times would you like the coin to be tossed?\n";
	cin >> times;

	//input validation
	while (times <= 0)
	{
		cout << "Value entered must be at least 1, try again.\n";
		cin >> times;
	}

	for (int counter = 1; counter <= times; counter++)
	{
		int result = coinToss();

		if (result == 0)
		{
			cout << "Tails!" << endl;
			tailsCount++;
		}

		else
		{
			cout << "Heads!" << endl;
			headsCount++;
		}

	}

	cout << "You got " << headsCount << " Heads and " << tailsCount << " Tails!" << endl;
	
	return 0;

}

int coinToss()
{
	return rand() % 2;
}