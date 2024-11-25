// PC3-14.cpp
// Jason Vo
// OCCC Fall 2024
// Programming Challenge 14 - Monthly Sales Tax

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main()
{
    //variables
    string monthYear;
    double totalCollected;
    double totalIncome;
    const double state_tax_rate = 0.04;
    const double county_tax_rate = 0.02;
    double stateTax, countyTax, totalTax;

    //asking for inputs and data
    cout << "Please enter the month and year:" << endl;
    getline(cin,monthYear);

    cout << "Please enter the total amount collected at the cash register:" << endl;
    cin >> totalCollected;

    //calculations
    totalIncome = totalCollected / 1.06;
    countyTax = totalIncome * county_tax_rate;
    stateTax = totalIncome * state_tax_rate;
    totalTax = countyTax + stateTax;



    //displaying results <<
    cout << "Month and Year: " << monthYear << endl;
    cout << left << setw(20) << "Total Collected: " << setprecision(2) << fixed << right << setw(10) << totalCollected << endl;
    cout << left << setw(20) << "Sales: " << setprecision(2) << fixed << right << setw(10) << totalIncome << endl;
    cout << left << setw(20) << "County Sales Tax: " << setprecision(2) << fixed << right << setw(10) << countyTax << endl;
    cout << left << setw(20) << "State Sales Tax: " << setprecision(2) << fixed << right << setw(10) << stateTax << endl;
    cout << left << setw(20) << "Total Sales Tax: " << setprecision(2) << fixed << right << setw(10) << totalTax << endl;
    return 0;

}
