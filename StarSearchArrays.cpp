// StarSearchArrays.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024

#include <iostream>
#include <iomanip>

using namespace std;

void getJudgeData(double&);
void getAllJudgeData(double[], int);
void calcScore(double[], int);
double findLowest(double[], int);
double findHighest(double[], int);

int main()
{
    //constant for size of the array
    const int NUMBER_OF_SCORES = 10;

    double scoresArray[NUMBER_OF_SCORES];

    //call the function getJudgeData, passing the array and size
    getAllJudgeData(scoresArray, NUMBER_OF_SCORES);

    //call the function calcScore
    calcScore(scoresArray, NUMBER_OF_SCORES);

       return 0;
}

// Function to get all judge scores and store them in an array
void getAllJudgeData(double scores[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << "Judge " << (i + 1) << ": ";
        getJudgeData(scores[i]);  // Pass each array element by reference
    }
}

void getJudgeData(double& value)
{
    const double MIN_SCORE = 0.0;
    const double MAX_SCORE = 10.0;

    // Ask for the score and store it in the reference parameter
    cout << "Enter the score from the judge: ";
    cin >> value;

    // Input validation
    while (value < MIN_SCORE || value > MAX_SCORE)
    {
        cout << "Invalid score, must be between " << MIN_SCORE << " and " << MAX_SCORE << ". Enter again: ";
        cin >> value;
    }
}


void calcScore(double scores[], int size)
{
    //accumualor and variable to hold average
    double total = 0;
    double average;

    const int numberOfDroppedScores = 2;

    for (int index = 0; index < size; index++)
    {
        total += scores[index];
    }
    //findLowest and highest called right here
    double lowest = findLowest(scores, size);
    double highest = findHighest(scores, size);

    double newTotal = total - (lowest + highest);

    //use sizeof operator to show the amount of array elements
    int numOfElements = size - numberOfDroppedScores;

    average = newTotal / numOfElements;

    cout << "The average score after dropping the highest and lowest score is: " << fixed << setprecision(2) << showpoint << average << endl;

}
double findLowest(double scores[], int size)
{
    //set the first [0] part of the array as the lowest, then compare each subsequent value
    double lowest = scores[0];

    //start the index at 1 instead, since 0 has been asigned already
    for (int index = 1; index < size; index++)
    {
        if (scores[index] < lowest)
            lowest = scores[index];
    }
    return lowest;
}


double findHighest(double scores[], int size) //similar to findLowest
{
    //set the first [0] part of the array as the highest, then compare each subsequent value
    double highest = scores[0];

    //start the index at 1 instead, since 0 has been asigned already
    for (int index = 1; index < size; index++)
    {
        if (scores[index] > highest)
            highest = scores[index];
    }
    return highest;
}