// PC4-12.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge 4-12: Software Sales

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    //variables (constants)
    const double REGULAR_PRICE = 99.00;
    const int DISCOUNT_20_QTY = 10;
    const int DISCOUNT_30_QTY = 20;
    const int DISCOUNT_40_QTY = 50;
    const int DISCOUNT_50_QTY = 100;
    const double DISCOUNT_20 = 0.20;
    const double DISCOUNT_30 = 0.30;
    const double DISCOUNT_40 = 0.40;
    const double DISCOUNT_50 = 0.50;

    int quantity;
    double discount = 0.00, regularPrice, discountValue, totalPrice;
    int discountPercentage;

    //ask for quantity of books sold
    cout << "Please enter quantity: " << endl;
    cin >> quantity;

    //if/else if statements
    if (quantity < 0)
    {
        cout << "Please enter a valid quantity.";
        return 1;
    }

    if (quantity >= DISCOUNT_50_QTY)
        discount = DISCOUNT_50;
    else if (quantity >= DISCOUNT_40_QTY)
        discount = DISCOUNT_40;
    else if (quantity >= DISCOUNT_30_QTY)
        discount = DISCOUNT_30;
    else if (quantity >= DISCOUNT_20_QTY)
        discount = DISCOUNT_20;

    //calculations
    discountPercentage = discount * 100;
    regularPrice = REGULAR_PRICE * quantity;
    discountValue = regularPrice * discount;
    totalPrice = regularPrice - discountValue;

    //outputting results
    cout << "Your discount is " << discountPercentage << "%" << endl;
    cout << left << setw(20) << "Regular Price: " << right << setw(10) << setprecision(2) << fixed << regularPrice << endl;
    cout << left << setw(20) << "Discount: " << right << setw(10) << setprecision(2) << fixed << discountValue << endl;
    cout << left << setw(20) << "Total Price: " << right << setw(10) << setprecision(2) << fixed << totalPrice << endl;

    return 0;

}