// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 1 Homework - Magic 8 Ball

import java.util.Scanner;

public class Magic_8_Ball {

    public static void main(String[] args) {
        
        // Creating scanner object
        Scanner input = new Scanner(System.in);
        
        // Array of type String that stores at least 10 responses, possible responses were found on: 
        // https://en.wikipedia.org/wiki/Magic_8_Ball
        String[] responses = new String[] {"It is certain", "As I see it, yes", "Reply hazy, try again", "Don't count on it", 
                                            "My reply is no", "Ask again later", "Most likely", "It is decidedly so", 
                                            "Without a doubt", "Outlook good", "Better not tell you now", "Very doubtful"};

        // Counter which will be incremented every time the loop iterates as user asks more questions
        int numberOfQuestionsAnswered = 0;

        System.out.println("This program will run the Magic 8 Ball algorithm.");

        // Declare userInput outside the loop so it is accessible in the loop condition
        String userInput;

        // Using a do-while loop which will continue running until an empty string is inputed
        do {
            // Prompt the user for a question
            System.out.println("Please enter a question that you wish to be answered.");
            
            // Accepting the question which will be stored within the string userInput
            userInput = input.nextLine();

            // Input validation, if user enters an empty string here
            if (userInput.isEmpty()) {
                break;
            }
            
            // Random number generator of type int from 0 to 11 (12 responses)
            int randomNumber = (int) (Math.random() * responses.length);
            
            // Using randomNumber, display a random response at the index of the randomNumber
            System.out.println(responses[randomNumber]);
            
            // Increment the counter
            numberOfQuestionsAnswered++;
            
        } while (!userInput.isEmpty());
        
        // Display the number of questions answered
        System.out.println(numberOfQuestionsAnswered + " questions were answered!");

        input.close();
    }
}
