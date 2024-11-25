// Chapter 3 Case Study - EXTRA CREDIT.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024

#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    // Constants for cost and amount charged
    const double COST_PER_CUBIC_FOOT = 0.23;
    const double CHARGE_PER_CUBIC_FOOT = 0.5;

    // Variables
    double length,  // The crate's length
        width,   // The crate's width
        height,  // The crate's height
        volume,  // The volume of the crate
        cost,    // The cost to build the crate
        charge,  // The customer charge for the crate
        profit;  // The profit made on the crate

 // Set the desired output formatting for numbers.
    cout << setprecision(3) << fixed << showpoint;

    // Prompt the user for the crate's length, width, and height.
    cout << "Enter the dimensions of the crate (in feet):\n";
    cout << "Length: "; 
    cin >> length;
    cout << "Width: "; 
    cin >> width;
    cout << "Height: "; 
    cin >> height;

    // Calculate the crate's volume, the cost to produce it,
    // the charge to the customer, and the profit.
    volume = length * width * height;
    cost = volume * COST_PER_CUBIC_FOOT;
    charge = volume * CHARGE_PER_CUBIC_FOOT;
    profit = charge - cost;

    // Display the first table: dimensions and volume.
    cout << "\nDimensions and Volume\n";
    cout << "------------------------\n";
    cout << "Length: " << setw(10) << length << " feet\n";
    cout << "Width:  " << setw(10) << width << " feet\n";
    cout << "Height: " << setw(10) << height << " feet\n";
    cout << "Volume: " << setw(10) << volume << " cubic feet\n";

    // Set formatting for currency output.
    cout << setprecision(2);

    // Display the second table: cost, charge, and profit.
    cout << "\nCost, Charge to Customer, and Profit\n";
    cout << "------------------------------\n";
    cout << "Cost:          $" << setw(10) << cost << endl;
    cout << "Charge         $" << setw(10) << charge << endl;
    cout << "Profit:        $" << setw(10) << profit << endl;

    return 0;
}
