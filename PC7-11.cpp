// PC7-11.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 11 - Exam Grader (parallel arrays)

#include <iostream>
#include <fstream>
#include <iomanip> // for left, right, setw

using namespace std;

// Function prototypes
void readStudentAnswers(char[], int);
void readCorrectAnswers(char[], int);
void finalScoreCalculator(char[], char[], int);

ifstream inputFile;

int main()
{
    // Constants and arrays
    const int NUMBER_OF_QUESTIONS = 101;
    char studentAnswerReader[NUMBER_OF_QUESTIONS];
    char answerChecker[NUMBER_OF_QUESTIONS];

    // Call functions
    readStudentAnswers(studentAnswerReader, NUMBER_OF_QUESTIONS);
    readCorrectAnswers(answerChecker, NUMBER_OF_QUESTIONS);
    finalScoreCalculator(studentAnswerReader, answerChecker, NUMBER_OF_QUESTIONS);

    return 0;
}

// Function to read the student's answers
void readStudentAnswers(char studentAnswers[], int numOfQuestions)
{
    string fileName;

    cout << "Please enter the file name for the student's answers: ";
    cin >> fileName;

    inputFile.open(fileName);
    while (!inputFile.is_open())
    {
        cout << "Invalid file name, please re-enter: ";
        cin >> fileName;
        inputFile.open(fileName);
    }

    int index = 0;
    while (index < numOfQuestions && inputFile >> studentAnswers[index]) {
        index++;
    }

    inputFile.close(); // Close file after reading
}

// Function to read the correct answers
void readCorrectAnswers(char correctAnswers[], int numOfQuestions)
{
    string fileName;

    cout << "Please enter the file name for the correct answers: ";
    cin >> fileName;

    inputFile.open(fileName);
    while (!inputFile.is_open())
    {
        cout << "Invalid file name, please re-enter: ";
        cin >> fileName;
        inputFile.open(fileName);
    }

    int index = 0;
    while (index < numOfQuestions && inputFile >> correctAnswers[index]) {
        index++;
    }

    inputFile.close(); // Close file after reading
}

// Function to compare answers and calculate the final score
void finalScoreCalculator(char studentAnswers[], char correctAnswers[], const int numOfQuestions)
{
    const int MINIMUM_PASSING_SCORE = 70;
    const int ARRAY_HOLDER = 90; // Make sure this is enough for possible missed questions
    int numberCorrect = 0;
    int numberIncorrect = 0;
    double percentageCorrect;
    int questionsMissed[ARRAY_HOLDER]; // To store the question numbers of incorrect answers
    int incorrectIndex = 0; // Initialize index for missed questions

    // Compare answers and count correct and incorrect
    for (int index = 0; index < numOfQuestions; index++)
    {
        if (studentAnswers[index] == correctAnswers[index])
        {
            numberCorrect++;
        }
        else
        {
            numberIncorrect++;
            questionsMissed[incorrectIndex++] = index + 1; // Store the missed question number
        }
    }

    // Calculate percentage correct
    percentageCorrect = (static_cast<double>(numberCorrect) / numOfQuestions) * 100;

    // Display missed questions
    if (numberIncorrect > 0)
    {
        cout << "\nQuestions Missed:\n";
        cout << "---------------------------------------" << endl;
        for (int i = 0; i < incorrectIndex; i++)
        {
            cout << "Question " << questionsMissed[i] << ": "; // Directly use the stored question number
            cout << "Student's answer: " << studentAnswers[questionsMissed[i] - 1] << ", "; // Access answer with index
            cout << "Correct answer: " << correctAnswers[questionsMissed[i] - 1] << endl; // Access answer with index
        }
    }

    // Display score and pass/fail result
    cout << fixed << setprecision(2);
    cout << "\nTotal number of correct answers: " << numberCorrect << endl;
    cout << "Total number of incorrect answers: " << numberIncorrect << endl;
    cout << "Your final score percentage is: " << percentageCorrect << "%" << endl;

    if (percentageCorrect >= MINIMUM_PASSING_SCORE)
    {
        cout << "Congratulations, you have passed the exam!" << endl;
    }
    else
    {
        cout << "Unfortunately, you have failed the exam." << endl;
    }
}
