// PC6-12.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Jason Vo
// OCCC Fall 2024
// Programming Challenge: 12 - Star Search

#include <iostream>
#include <iomanip>

using namespace std;

void getJudgeData(double&);
void calcScore(double, double, double, double, double);
double findLowest(double, double, double, double, double);
double findHighest(double, double, double, double, double);

//global constants to set the max and minimum scores, they go outside int main
const double MIN_SCORE = 0.0;
const double MAX_SCORE = 10.0;

int main()
{

	//variables to hold the judge data/scores
	double score1, score2, score3, score4, score5;

	//asking for judge data using getJudgeData
	getJudgeData(score1);
	getJudgeData(score2);
	getJudgeData(score3);
	getJudgeData(score4);
	getJudgeData(score5);

	//average them all up (lowest and highest should be dropped during the calcScore function)
	
	calcScore(score1, score2, score3, score4, score5);

	return 0;

}

void getJudgeData(double& value)
{
	
	//this will ask, then store it in a a reference parameter after validation
	cout << "Enter the score from the judge: \n";
	cin >> value;

	while (value < MIN_SCORE || value > MAX_SCORE)
	{
		cout << "Invalid score, cannot be lower than 0 or higher than 10\n";
		cin >> value;
	}
}

void calcScore(double score1, double score2, double score3, double score4, double score5)
{
	//first, grab the total of all 5
	double total = score1 + score2 + score3 + score4 + score5;


	//then, call the findLowest and findHighest
	double lowest = findLowest(score1, score2, score3, score4, score5);

	double highest = findHighest(score1, score2, score3, score4, score5);

	//using the returned values (lowest) (hihgest), subtract these from the total
	double droppedTotal = total - lowest - highest;

	//using droppedTotal, divide by 3.0
	double average = droppedTotal / 3.0;

	//display the averaged score, Show results with exactly two digits after the decimal point.

	cout << "The average score after dropping the highest and lowest score is: " << fixed << setprecision(2) << average << endl;

}

double findLowest(double score1, double score2, double score3, double score4, double score5)
{
	double lowest = score1;

	if (score2 < lowest)
		lowest = score2;
	if (score3 < lowest)
		lowest = score3;
	if (score4 < lowest)
		lowest = score4;
	if (score5 < lowest)
		lowest = score5;

	return lowest;
}

double findHighest(double score1, double score2, double score3, double score4, double score5)
{
	double highest = score1;

	if (score2 > highest)
		highest = score2;
	if (score3 > highest)
		highest = score3;
	if (score4 > highest)
		highest = score4;
	if (score5 > highest)
		highest = score5;

	return highest;
}