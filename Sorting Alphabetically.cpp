// Sorting Alphabetically.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include <string>
#include <cctype>
#include <algorithm>

using namespace std;

//functions
void selectionSort(string[], int);


ifstream inputFile;

int main()
{
    string fileName;

    const int arraySize = 1000;
    string wordsArray[arraySize];

    string temp;
    int wordCount = 0;
   
    cout << "Please enter the file name: ";
    getline(cin, fileName);

    inputFile.open(fileName);

    while (!inputFile)
    {
        cout << "\nIncorrect. Please enter the file name: ";
        getline(cin, fileName);

        inputFile.open(fileName);
    }

    int index = 0;

    // Read words from the file
    while (getline(inputFile, temp) && wordCount < arraySize)
    {
        if (!temp.empty()) // Skip empty lines
        {
            wordsArray[wordCount] = temp;
            wordCount++;
        }
    }

    

    //array is now filled, now must sort with function
    selectionSort(wordsArray, wordCount);

    int value;

    cout << "Enter an index and I will tell you the word found at that index.\n";
    cin >> value;

    cout << "The word at " << value << " index is " << wordsArray[value];

    //now use binary search function, have a third variable that will be incremented in the function, then returned



}

void selectionSort(string array[], int size)
{
    int startScan, minIndex;
    string minValue;

    for (startScan = 0; startScan < (size - 1); startScan++)
    {
        minIndex = startScan;
        minValue = array[startScan];

        //now scan the unsorted section
        for (int index = startScan + 1; index < size; index++)
        {
            if (toLower(array[index]) < toLower(minValue))
            {
                minValue = array[index];
                minIndex = index;
            }
        }

        array[minIndex] = array[startScan];
        array[startScan] = minValue;
    }
}
