// PC5-21.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 21 - Random Number Guessing Game Enhancement

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main()
{
	//variables
	int numberOfguesses = 0;
	long long randomNumber = 0;
	int guessAttempt;

	// Seed the random number generator with the current time
	srand(static_cast<unsigned int>(time(0)));

	// Generate a nine-digit random number
	randomNumber = 100000000 + rand() % 900000000;

	//ask user for guess
	cout << "The program has generated a random number. Guess what the number is: " << endl;

	//loop to keep track
	do
	{
		cin >> guessAttempt;
		numberOfguesses++;

		if (guessAttempt < randomNumber)
			cout << "Too low, try again";
		else if (guessAttempt > randomNumber)
			cout << "Too high, try again";

	} while (guessAttempt != randomNumber);

	//when corectly guessed, display number for 
	cout << "Congrats! It took you " << numberOfguesses << " guesses to find the answer!" << endl;

	return 0;

}

/*Pseudocode
* ask user to enter a guess
* increment the variable guess
* when they are able to break out the loop
*/