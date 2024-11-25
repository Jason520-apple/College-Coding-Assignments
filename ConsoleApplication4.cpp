// PC6-11.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 11 - Lowest Score Drop

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>

using namespace std;

bool validationFunction(double score);
void calculateAverageAndDisplay(const string&);

int main()
{
    string filename;

    // Prompt for the file name
    cout << "Enter the name of the file containing the scores: ";
    getline(cin, filename);

    // Calculate average after dropping the lowest score
    calculateAverageAndDisplay("Random Doubles.txt");

    return 0;
}

// Function to calculate average after dropping the lowest score
void calculateAverageAndDisplay(const string& filename)
{
    ifstream inputFile(filename);
    if (!inputFile) {
        cerr << "Error opening file: " << filename << endl;
        return; // Exit the function if the file cannot be opened
    }

    double score;
    double total = 0.0;
    double lowestScore = std::numeric_limits<double>::max(); // Initialize to max double
    int count = 0;

    // Read scores from the file
    while (inputFile >> score) {
        total += score; // Add to total
        count++; // Increment count

        // Update the lowest score if necessary
        if (score < lowestScore) {
            lowestScore = score;
        }
    }

    inputFile.close(); // Close the file after reading

    // Calculate the average after dropping the lowest score
    if (count > 1) { // We need at least 2 scores to drop one
        double droppedTotal = total - lowestScore;
        double averageScore = droppedTotal / (count - 1);
        cout << "The average score (after dropping the lowest) is " << fixed << setprecision(2) << averageScore << endl;
    }
    else if (count == 1) {
        cout << "Only one valid score entered. Cannot drop the lowest." << endl;
    }
    else {
        cout << "No valid scores entered." << endl;
    }
}

// Bool validation function (not used in this version since no restrictions are applied)
bool validationFunction(double score)
{
    return true; // Always return true since there's no restriction
}
