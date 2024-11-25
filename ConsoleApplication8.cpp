#include <iostream>
#include <fstream>
#include <string>
#include <algorithm> // for std::transform

using namespace std;

// Function prototypes
void selectionSort(string[], int);
int getValidIndex(int, int);
string toLower(const string&);

int main()
{
    string fileName;
    const int arraySize = 1000;
    string wordsArray[arraySize];
    string temp;
    int wordCount = 0; // To track how many words are actually read

    cout << "Please enter the file name: ";
    getline(cin, fileName);

    ifstream inputFile(fileName);

    while (!inputFile) // Input validation for file
    {
        cout << "\nIncorrect. Please enter the file name: ";
        getline(cin, fileName);

        inputFile.open(fileName);
    }

    // Read words from the file
    while (getline(inputFile, temp) && wordCount < arraySize)
    {
        if (!temp.empty()) // Skip empty lines
        {
            wordsArray[wordCount] = temp;
            wordCount++;
        }
    }

    inputFile.close(); // Close file after reading

    // Sort the array using selection sort
    selectionSort(wordsArray, wordCount);

    // Prompt user for index and display the word
    int index;
    cout << "Enter an index (0 to " << wordCount - 1 << ") and I will tell you the word found at that index: ";
    index = getValidIndex(0, wordCount - 1);

    cout << "The word at index " << index << " is: " << wordsArray[index] << endl;

    return 0;
}

// Function to convert string to lowercase for case-insensitive comparison
string toLower(const string& str)
{
    string lowerStr = str;
    transform(lowerStr.begin(), lowerStr.end(), lowerStr.begin(), ::tolower);
    return lowerStr;
}

// Selection sort function to sort strings alphabetically (case-insensitive)
void selectionSort(string array[], int size)
{
    int startScan, minIndex;
    string minValue;

    for (startScan = 0; startScan < (size - 1); startScan++)
    {
        minIndex = startScan;
        minValue = array[startScan];

        // Scan the unsorted section of the array
        for (int index = startScan + 1; index < size; index++)
        {
            // Compare strings in a case-insensitive way
            if (toLower(array[index]) < toLower(minValue))
            {
                minValue = array[index];
                minIndex = index;
            }
        }

        // Swap the smallest element with the element at startScan
        array[minIndex] = array[startScan];
        array[startScan] = minValue;
    }
}

// Function to get a valid index from the user
int getValidIndex(int min, int max)
{
    int index;
    while (true)
    {
        cin >> index;
        if (cin.fail() || index < min || index > max)
        {
            cin.clear(); // Clear invalid input flag
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Discard invalid input
            cout << "Invalid index! Please enter a number between " << min << " and " << max << ": ";
        }
        else
        {
            break; // Valid input, exit loop
        }
    }
    return index;
}
