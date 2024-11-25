// PC6-11.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fal 2024
// Programming Challenge: 11 - Lowest Score Drop

#include <iostream>
#include <iomanip>

using namespace std;

void getScore (double &);
void calcAverage (double, double, double, double, double);
double findLowest(double, double, double, double, double);
bool validationFunction(double);

const double MIN_SCORE = 0;
const double MAX_SCORE = 100;

int main() 
{

	double score1, score2, score3, score4, score5;

	getScore(score1);
	getScore(score2);
	getScore(score3);
	getScore(score4);
	getScore(score5);

	calcAverage(score1, score2, score3, score4, score5);

	return 0;
}

//this function will ask for a test score
void getScore(double & score)
{
	cout << "Enter a test score: " << endl;
	cin >> score;

	validationFunction(score);

	while (!validationFunction(score))
		{
			cout << "Invalid score, please enter again: \n";
			cin >> score;
		}
}


//bool validation function
bool validationFunction(double score)
{
	if (score < MIN_SCORE || score > MAX_SCORE)
		return false;
	else
		return true;
}


//calculate the average, will drop the lowest score, call the lowest score function
void calcAverage(double a, double b, double c, double d, double e)
{

	double total = a + b + c + d + e;

	double lowestScore = findLowest(a, b, c, d, e); //returns the lowest and puts it here

	double droppedTotal = total - lowestScore;

	double averageScore = (droppedTotal / 4.0);


	cout << "The average score is " << fixed << setprecision(2) << averageScore << endl;

}


//find the lowest scores
double findLowest(double a, double b, double c, double d, double e)
{
	double lowestScore = a; //start at a, then compare and update as it goes down

	if (b < lowestScore)
		lowestScore = b;
	if (c < lowestScore)
		lowestScore = c;
	if (d < lowestScore)
		lowestScore = d;
	if (e < lowestScore)
		lowestScore = e;

	return lowestScore;
}