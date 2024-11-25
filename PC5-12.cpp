// PC5-12.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 12 - Celsius to Fahrenheit table

#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

int main()
{

	//variables to hold user inputs
	float startCelsius, stopCelsius;
	
	//asking for user inputs
	cout << "Please enter the starting temperature (Celsius): " << endl;
	cin >> startCelsius;

	cout << "Please enter the stop temperature(Celsius): " << endl;
	cin >> stopCelsius;

	//if else to reorder the user inputs
	if (startCelsius > stopCelsius)
	{
		float temp = startCelsius;
		startCelsius = stopCelsius;
		stopCelsius = temp;
	}

	//floor and ceiling

	int floor_startCelsius = floor(startCelsius);
	int ceil_stopCelsius = ceil(stopCelsius);


	//variables conversion

	int Celsius;
	const double FahrenheitConversion1 = 1.8;
	const int FahrenheitConversion2 = 32;

	//table
	cout << "Celsius to Fahrenheit" << endl;
	cout << "------------------------" << endl;

	//loop (intiitalize, test, update/increment)

	for (Celsius = floor_startCelsius; Celsius <= ceil_stopCelsius; Celsius++)
	{
		cout << left << setw(6) << Celsius << "\t" << fixed << setprecision(2) << (Celsius * FahrenheitConversion1 + FahrenheitConversion2) << endl;
	}
	return 0;

}

/* outline of plan (pseudocode)
* ask for user to input the start temperature floating number
* ask the user to input the stop temperature for the table floating
* hw asks to take the start value down to lower integer (12.9 = 12)
* for stop temperature round up to int
* this will be done using cmath functuion of floor() and ceil()
*      int floor_x = floor(x);
* making table: use set precision, right justified, and show in 1 degree increments
* Celsius as ints on left, Fahrenheit with setprecision(2) fixed
*
*/