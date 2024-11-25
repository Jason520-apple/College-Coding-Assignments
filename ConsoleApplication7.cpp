#include <iostream>
#include <string>
#include <fstream>

using namespace std;

void readArray(int[], int);
int sequentialSearch(int[], int, int);
int sequentialSearchComparisonsNumber(int arr[], int size, int searchItemValue);
int sort(int[], int);
void mySwap(int&, int&);
int binarySearch(int[], int, int);
int binarySearchComparisonsNumber(int[], int, int);

ifstream inputFile;

int main() {
    const int fileSize = 100000;
    int array[fileSize];

    int searchItem, searchItem2;

    // Prompt user for file, read into an array
    readArray(array, fileSize);

    // Prompt the user for a search item
    cout << "Please enter a search item: ";
    cin >> searchItem;

    int result = sequentialSearch(array, fileSize, searchItem);

    if (result == -1) {
        cout << "Nothing found in linear search.\n";
    }
    else {
        cout << "At position " << result << ", item " << searchItem << " was found using linear search.\n";
    }

    int num = sequentialSearchComparisonsNumber(array, fileSize, searchItem);
    cout << "Linear search took " << num << " comparisons.\n";

    // Sort the array, then use binary search
    cout << "Sorting the array...\n";
    int sortNum = sort(array, fileSize);
    cout << "Array sorted in " << sortNum << " comparisons.\n";

    // Prompt for another search item after sorting
    cout << "Please enter a search item for binary search: ";
    cin >> searchItem2;

    // Binary search
    int result2 = binarySearch(array, fileSize, searchItem2);
    int num2 = binarySearchComparisonsNumber(array, fileSize, searchItem2);

    if (result2 == -1) {
        cout << "Nothing found in binary search.\n";
    }
    else {
        cout << "At position " << result2 << ", item " << searchItem2 << " was found using binary search.\n";
    }

    cout << "Binary search took " << num2 << " comparisons.\n";
}

void readArray(int arr[], int size) {
    string fileName;
    int index = 0;

    cout << "Please enter a file containing 100,000 unsorted integers: ";
    cin.ignore();  // Ignore any leftover newline character
    getline(cin, fileName);

    inputFile.open(fileName);

    while (!inputFile) {
        cout << "Error opening file. Please try again: ";
        getline(cin, fileName);
        inputFile.open(fileName);
    }

    while (index < size && inputFile >> arr[index]) {
        index++;
    }

    inputFile.close();
}

int sequentialSearch(int arr[], int size, int searchItemValue) {
    int index = 0;
    int position = -1;

    while (index < size) {
        if (arr[index] == searchItemValue) {
            position = index;
            break;
        }
        index++;
    }

    return position;
}

int sequentialSearchComparisonsNumber(int arr[], int size, int searchItemValue) {
    int index = 0;

    while (index < size) {
        if (arr[index] == searchItemValue) {
            break;
        }
        index++;
    }

    return index + 1;  // Return number of comparisons
}

int sort(int arr[], int size) {
    int minValue, minIndex;
    int count = 0;

    for (int start = 0; start < size - 1; start++) {
        minIndex = start;
        minValue = arr[start];

        for (int index = start + 1; index < size; index++) {
            if (arr[index] < minValue) {
                minValue = arr[index];
                minIndex = index;
            }
            count++;  // Count only comparisons
        }
        mySwap(arr[minIndex], arr[start]);
    }

    return count;
}

void mySwap(int& a, int& b) {
    int temp = a;
    a = b;
    b = temp;
}

int binarySearch(int arr[], int size, int searchItemValue) {
    int first = 0, last = size - 1, middle, position = -1;

    while (first <= last) {
        middle = (first + last) / 2;
        if (arr[middle] == searchItemValue) {
            position = middle;
            break;
        }
        else if (arr[middle] > searchItemValue) {
            last = middle - 1;
        }
        else {
            first = middle + 1;
        }
    }

    return position;
}

int binarySearchComparisonsNumber(int arr[], int size, int searchItemValue) {
    int first = 0, last = size - 1, middle;
    int count = 0;

    while (first <= last) {
        middle = (first + last) / 2;
        count++;  // Count each comparison

        if (arr[middle] == searchItemValue) {
            break;
        }
        else if (arr[middle] > searchItemValue) {
            last = middle - 1;
        }
        else {
            first = middle + 1;
        }
    }

    return count;
}
