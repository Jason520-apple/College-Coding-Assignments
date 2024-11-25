// PC2-12.cpp
// Jason Vo
// OCCC Fall 2024
// Chapter 3 Warm Up Problem (Extra Credit) - Acres and Square Feet

#include <iostream>
using namespace std;

int main()
{
    //variables
    double numberOfacres; 
    int squareFeet;
    const int acre = 43560;

    //prompting user for number of acres
    cout << "Please provide the number of acres:" << endl;
    cin >> numberOfacres;

    //computing the number of square feet
    squareFeet = numberOfacres * acre;

    //display output
    cout << "The number of square feet in " << numberOfacres << " acres is: " << squareFeet << endl;
    return 0;

}

