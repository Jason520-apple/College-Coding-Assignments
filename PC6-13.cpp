// PC6-13.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 13 - Days Out

#include <iostream>
#include <iomanip>

using namespace std;

//function called by main that asks the user for number of employees in the company, return an int and accept no arguments
int numberOfemployees();

//function called by main that accepts argument from above (number of employees)
//ask the user to enter the number of days each employee missed, totalDays returned as int
int daysMissed(int employees);

//function called by main that takes two arguments: numberOfemployees and daysMissed, then returns double averageDaysabsent
double averageDaysabsent(double employees, double daysMissed);



int main()
{
    //variables to hold data
    //calling number of employees
    int numberOfEmployees = numberOfemployees();

    //calling daysMissed
    int DaysMissed = daysMissed(numberOfEmployees);

    //calling averageDaysabsent
    double average = averageDaysabsent(numberOfEmployees, DaysMissed);

    //display
    cout << "The average number of days that your company's employees are absent is: ";
    cout << fixed << setprecision(2) << average << " days!";

    return 0;

}

int numberOfemployees()
{
    int number;
    cout << "Enter the number of employees in the company: \n";
    cin >> number;

    while (number < 1)//input validation
    {
        cout << "Invalid number, please try again\n";
        cin >> number;
    }

    return number;
}

int daysMissed(int employees)
{
    int sum = 0;

    for (int initalValue = 1; initalValue <= employees; initalValue++)
    {
        //local variable
        int daysMissed;

        cout << "Days out for Employee " << initalValue << ": ";
        cin >> daysMissed;

        while (daysMissed < 0)
        {
            cout << "Invalid number, cannot be a negative number! :( Try Again!\n";
            cout << "Days out for Employee " << initalValue << ": ";
            cin >> daysMissed;
        }

        sum += daysMissed;
    }

    return sum;
}

double averageDaysabsent(double employees, double totalDaysAbsent)
{
    double average = (totalDaysAbsent / employees);
    return average;
}