#include <iostream>
#include <fstream>
#include <string>

using namespace std;

bool isPrime(int);

int main()
{
    int number;
    int primeNumberCounter = 0;
    ifstream inputFile;

    // Update the path as necessary
    inputFile.open("Big List of Random Integers.txt");

    // Check if the file was opened successfully
    if (!inputFile) {
        cerr << "Error opening file: C:\\Users\\ancom\\Downloads\\Big List of Random Integers.txt" << endl;
        return 1; // Exit the program if the file cannot be opened
    }

    // Read numbers from the file and count primes
    while (inputFile >> number) {
        cout << "Read number: " << number << endl; // Debug output
        if (isPrime(number))
            primeNumberCounter++;
    }

    inputFile.close();

    cout << "There are " << primeNumberCounter << " prime numbers in the file." << endl;

    return 0;
}

bool isPrime(int number) {
    if (number <= 1)
        return false; // Numbers less than or equal to 1 are not prime
    for (int a = 2; a < number; a++) {
        if (number % a == 0) // If divisible by any a, it's not prime
            return false;
    }
    return true; // If no divisors were found, the number is prime
}
