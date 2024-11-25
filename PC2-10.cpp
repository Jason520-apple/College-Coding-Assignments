// PC2-10.cpp
//Jason Vo
//OCCC Fall 2024
//Programming Challenge 10 (miles per gallon)

#include <iostream>
using namespace std;

int main()
{
	//Variables for miles and gallons
	double milesDriven, miles_per_gallon;
	double gallonsOf_GasUsed;

	//Asking user for miles driven
	cout << "How many miles did you drive?";
	cin >> milesDriven;

	//Asking for gallons of gas used
	cout << "How many gallons of gas did you use?";
	cin >> gallonsOf_GasUsed;

	//Calculating number of miles per gallon the car gets
	miles_per_gallon = milesDriven / gallonsOf_GasUsed;

	//Displaying the miles per gallon
	cout << "Your car gets " << miles_per_gallon << " miles per gallon." << endl;
	return 0;
}
