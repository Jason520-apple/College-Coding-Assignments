#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

// Sequential Search function
int sequentialSearch(const vector<int>& arr, int target, int& comparisons) {
    comparisons = 0;
    for (size_t i = 0; i < arr.size(); ++i) {
        comparisons++;
        if (arr[i] == target) {
            return i;  // Return the index where the item was found
        }
    }
    return -1;  // Return -1 if the item was not found
}

// Binary Search function
int binarySearch(const vector<int>& arr, int target, int& comparisons) {
    int low = 0, high = arr.size() - 1;
    comparisons = 0;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        comparisons++;
        if (arr[mid] == target) {
            return mid;
        }
        else if (arr[mid] < target) {
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
    }
    return -1;  // Return -1 if the item was not found
}

int main() {
    string filename;
    cout << "Enter the filename containing 100,000 integers: ";
    cin >> filename;

    // Reading integers from file
    ifstream file(filename);
    if (!file) {
        cerr << "Error opening file!" << endl;
        return 1;
    }

    vector<int> numbers;
    int num;
    while (file >> num) {
        numbers.push_back(num);
    }
    file.close();

    // Prompt for search item
    int searchItem;
    cout << "Enter the integer to search for: ";
    cin >> searchItem;

    // Sequential Search
    int comparisons;
    int index = sequentialSearch(numbers, searchItem, comparisons);
    cout << "Sequential search comparisons: " << comparisons << endl;

    // Sort the array
    cout << "Sorting the array (this may take a minute)..." << endl;
    sort(numbers.begin(), numbers.end());

    // Binary Search
    index = binarySearch(numbers, searchItem, comparisons);
    cout << "Binary search comparisons: " << comparisons << endl;

    return 0;
}
