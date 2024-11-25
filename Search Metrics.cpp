// Search Metrics.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo

#include <iostream>
#include <string>
#include <fstream>

using namespace std;

void readArray(int[], int);
int sequentialSearch(int[], int, int);
int sequentialSearchComparisonsNumber(int arr[], int size, int searchItemValue);

int sort(int[], int, int); // this will call swap
void mySwap(int&, int&);
int binarySearch(int[], int, int);
int binarySearchComparisonsNumber(int[], int, int);

ifstream inputFile;

int main()
{

	const int fileSize = 100000;
		int array[fileSize];

		int searchItem, searchItem2;
	
	//prompt user for file, read into an array
	readArray(array, fileSize);

	//prompt the user for a search item
	cout << "Please enter a search item: ";
	cin >> searchItem;

	int result = sequentialSearch(array, fileSize, searchItem);

	if (result == -1)
	{
		cout << "nothing found";
	}
	else
	{
		cout << "\nThis is linear search. At " << searchItem << " , " << result << " was found.\n";
	}
	
	int num = sequentialSearchComparisonsNumber(array, fileSize, searchItem);
	cout << "It took " << num << " comparisons.\n";

	//sort the array, then use binary search 
	cout << "This is binary search.\n";
	cout << "Please enter a search item: ";
	cin >> searchItem2;

	//sort first, then binary search
	sort(array, fileSize, searchItem2);

	int sortNum = sort(array, fileSize, searchItem2);
	//array is now sorted

	int result2 = binarySearch(array, fileSize, searchItem2);

	int num2 = binarySearchComparisonsNumber(array, fileSize, searchItem2);

	if (result2 == -1)
	{
		cout << "nothing found";
	}
	else
	{
		cout << "\nThis is binary search. At " << searchItem2 << " , " << result2 << " was found.\n";
	}

	cout << "It took " << sortNum << " comparisons.\n";

}

void readArray(int arr[], int size)
{
	string fileName;
	int index = 0;

	cout << "Please enter a file containing 100,000 unsorted integers: ";
	getline(cin, fileName);

	inputFile.open(fileName);

	while (!inputFile)
	{
		cout << "Try again pls";
		getline(cin, fileName);
	}

	while (index < size && inputFile >> arr[index])
		index++;
}

int sequentialSearch (int arr[], int size, int searchItemValue)
{
	int index = 0;
	int position = -1;
	bool found = false;

	while (index < size && !found)
	{
		if (arr[index] == searchItemValue)
		{
			found = true;
			position = index;
		}
		index++;
	}
	return position;
}

int sequentialSearchComparisonsNumber(int arr[], int size, int searchItemValue)
{
	int index = 0;
	int position = -1;
	bool found = false;

	while (index < size && !found)
	{
		if (arr[index] == searchItemValue)
		{
			found = true;
			position = index;
		}
		index++;
	}
	return index;
}

int sort(int arr[], int size, int searchItemValue)
{
	//sorting in ascending order, strings sorted may contain spaces
	int minValue;
	int minIndex;
	int count = 0;


	//start from the beginning of array, as first element in array is possibly updated
	//then skip over the first element, redo loop, then skip over second, etc
	for (int start = 0; start < size - 1; start++)
	{
		minIndex = start;
		minValue = arr[start];


		for (int index = start + 1; index < size; index++)
		{
			if (arr[index] < minValue)
			{
				minValue = arr[index];
				minIndex = index;
			}
			count++;
		}
		//swap function will be called at the end of the function
		mySwap(arr[minIndex], arr[start]);
	}

	return count;
}

void mySwap(int& a, int& b)
{
	int temporary = a;
	a = b;
	b = temporary;
}


int binarySearch(int arr[], int size, int searchItemValue)
{
	int first = 0,
		last = size - 1,
		middle,
		position = -1;
	bool found = false;

	while (!found && first <= last)
	{
		middle = (first + last) / 2;
		if (arr[middle] == searchItemValue)
		{
			found = true;
			position = middle;
		}
		else if (arr[middle] > searchItemValue)
		{
			last = middle - 1;
		}
		else if(arr[middle] < searchItemValue)
		{
			first = middle + 1;
		}
	}
	
	return position;
}

int binarySearchComparisonsNumber(int arr[], int size, int searchItemValue)
{
	int first = 0, last = size - 1, middle, position = -1;
	bool found = false;
	int count = 0;

	while (!found && first <= last) {
		
		middle = (first + last) / 2;
		
		count++;

		if (arr[middle] == searchItemValue)
		{
			found = true;
			position = middle;
		}
		else if (arr[middle] > searchItemValue)
			last = middle - 1;
		else if (arr[middle] < searchItemValue)
			first = middle + 1;
	}
	return count;
}