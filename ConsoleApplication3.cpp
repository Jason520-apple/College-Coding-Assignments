// PC6-11.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 11 - Lowest Score Drop

#include <iostream>
#include <iomanip>
#include <fstream>

using namespace std;

void getScoresFromFile(const string&);
bool validationFunction(double);

const double MIN_SCORE = 0;
const double MAX_SCORE = 100;

int main()
{
    string filename;

    // Prompt for the file name
    cout << "Enter the name of the file containing the scores: ";
    cin.ignore(); // Clear the input buffer
    getline(cin, filename);

    // Call the function to get scores from the file
    getScoresFromFile(filename);

    return 0;
}

void getScoresFromFile(const string& filename)
{
    ifstream inputFile(filename);
    if (!inputFile) {
        cerr << "Error opening file: " << filename << endl;
        return; // Exit the function if the file cannot be opened
    }

    double score;
    double total = 0.0;
    double lowestScore = MAX_SCORE + 1; // Initialize to a value greater than MAX_SCORE
    int count = 0;

    // Read scores from the file
    while (inputFile >> score) {
        if (validationFunction(score)) {
            total += score; // Add to total
            count++; // Increment count

            // Update the lowest score if necessary
            if (score < lowestScore) {
                lowestScore = score;
            }
        }
        else {
            cout << "Invalid score encountered: " << score << endl;
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

// Bool validation function
bool validationFunction(double score)
{
    return score >= MIN_SCORE && score <= MAX_SCORE; // Return true if the score is within the valid range
}
