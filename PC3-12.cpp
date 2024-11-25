// PC3-12.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge 12 - Celsius to Farenheit

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    //variables
    double Celsius, Fahrenheit;

    //asking for celsius, setprecision(2) << fixed
    cout << "Please enter the Celsius temperature:" << endl;
    cin >> Celsius;

    //calculate
    Fahrenheit = ((9.0 / 5.0) * Celsius) + 32;

    //output
    cout << setprecision(2) << fixed << Celsius << " degrees Celsius is equal to " << setprecision(2) << fixed << Fahrenheit << " degrees Fahrenheit." << endl;
    return 0;
}
