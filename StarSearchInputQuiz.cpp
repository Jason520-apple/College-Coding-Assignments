// StarSearch.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024

#include <iostream>
#include <fstream>
#include <iomanip>
#include <limits> // For std::numeric_limits

using namespace std;

int main() {
    // Open the input file
    ifstream inputFile("StarSearchInput.txt"); // Change this to the appropriate filename if needed
    if (!inputFile) {
        cout << "Error opening file!" << endl;
        return 1; // Exit if the file cannot be opened
    }

    double score;
    double total = 0.0;
    double lowest = numeric_limits<double>::max(); // Start with max double value
    double highest = numeric_limits<double>::min(); // Start with min double value
    int validScoresCount = 0; // Counter for valid scores

    // Read scores from the file
    while (inputFile >> score) {
        if (score >= 0.0 && score <= 10.0) { // Check if score is valid
            total += score;
            validScoresCount++;

            // Update lowest and highest
            if (score < lowest) {
                lowest = score;
            }
            if (score > highest) {
                highest = score;
            }
        }
    }

    inputFile.close(); // Close the file

    // Check if there are enough valid scores to calculate the average
    if (validScoresCount <= 2) {
        cout << "Not enough valid scores to calculate an average." << endl;
        return 1; // Exit if not enough scores to drop lowest and highest
    }

    // Calculate the new total after dropping lowest and highest
    total -= (lowest + highest);
    double average = total / (validScoresCount - 2); // Average of the remaining scores

    // Display the average with three decimal places
    cout << "The average score after dropping the highest and lowest score is: "
        << fixed << setprecision(3) << average << endl;

    return 0;
}
