// PC4-15.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC FALL 2024
// Programming Challenge: 15 - Shipping Charges

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    //variables and constants
    double distance, rate;
    double charges;
    double weight;

    //rate 2kg, etc
    const double RATE_1 = 1.10;
    const double RATE_2 = 2.20;
    const double RATE_3 = 3.70;
    const double RATE_4 = 4.80;

    //weight
    const double WEIGHT_RATE_4 = 10.0;
    const double WEIGHT_RATE_3 = 6.0;
    const double WEIGHT_RATE_2 = 2.0;


    //weight of packages
    const double MIN_WEIGHT = 0.0;
    const double MAX_WEIGHT = 20.0;

    //range of distances
    const int MIN_DISTANCE = 10;
    const int MAX_DISTANCE = 3000;
    const int MILES_INCREMENT = 500;

    //ask for weight and distance
    cout << "What is the weight of the package (kg): ";
    cin >> weight;

    cout << "What is the distance that it will be shipped (miles): ";
    cin >> distance;

    // if /else if for weight
    if (weight < MIN_WEIGHT)
        weight = MIN_WEIGHT;
    else if (weight > MAX_WEIGHT)
    {
        cout << "The packwage weight exceeds the maximum weight of " << MAX_WEIGHT << " kg.";
        return 1;
    }

    //weight if else
    if (weight >= WEIGHT_RATE_4 && weight <= MAX_WEIGHT)
        rate = RATE_4;
    else if (weight >= WEIGHT_RATE_3)
        rate = RATE_3;
    else if (weight >= WEIGHT_RATE_2)
        rate = RATE_2;
    else if (weight <= WEIGHT_RATE_2)
        rate = RATE_1;

    //distance if else validation

    if (distance < 0)
        distance = 0;
    else if (distance < MIN_DISTANCE)
    {
        cout << "Invalid distance, minimum is " << MIN_DISTANCE;
        return 1;
    }
    else if (distance > MAX_DISTANCE)
    {
        cout << "Invalid distance, maximum is " << MAX_DISTANCE;
        return 1;
    }

    //distance incrementation
    if (distance < MILES_INCREMENT)
        distance = MILES_INCREMENT;

    int increments = static_cast<int>(distance / MILES_INCREMENT);
    if (distance > increments * MILES_INCREMENT)
        increments++;

    //calculate
    charges = increments * rate;

    //display
    cout << left << "The shipping charge is $" << setprecision(2) << fixed << right << charges << endl;

    return 0;
}
