package triviaMaze;

import io.Database;
import io.Trivia;

import java.awt.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class PromptUser {

    private Scanner myUserInput; // use to take all input from the user
    private String myUserName; // the username

    // The PromptUser constructor
    public PromptUser(){
        this.myUserInput = new Scanner(System.in); //get the input from the user
        this.myUserName = ""; //Initial to empty string
    }

    //Return the username
    //Take username from the player input and return it
    public String userName() {

        System.out.println("Please enter your username: ");
        this.myUserName = myUserInput.nextLine();

        //The player have to create the username.
        while (this.myUserName.isEmpty()){
            System.out.println("You did not enter your username, please enter your username:");
            this.myUserName = myUserInput.nextLine();
        }

        System.out.println("Welcome " + this.myUserName +  " to the Husky Trivia Maze Game.");

        return this.myUserName;
    }
    
    //There are three three difficulty level for the game:
    //B for Beginner game: 4x4 maze
    //M for Medium game: 8x8 maze
    //H for Hard game: 15x15 maze
    // return the maze size for each level
    public int userMazeSize(){
        char myLevel = '\0';
        String myUserLevel = "";

        System.out.println("The levels of the Husky Trivia Maze Game: \n" +
                "Type B for Beginner level: 4x4 maze game.\n" +
                "Type M for Medium level: 8x8 maze game.\n" +
                "Type H for Hard level: 15x15 maze game.\n" +
                "Please select the level:");
        myUserLevel = myUserInput.nextLine();
        myLevel = myUserLevel.toUpperCase().charAt(0); //For the case that the user input the lower case

        while( myLevel != 'B' && myLevel != 'M' && myLevel != 'H') {
            System.out.println(myLevel + " is invalid option, please select the level (B, M, H):");
            myUserLevel = myUserInput.nextLine();
            myLevel = myUserLevel.toUpperCase().charAt(0);
        }

        if (myLevel == 'B') {
            System.out.println("You select the beginner level.");
            return 4;
        } else if ( myLevel == 'M') {
            System.out.println("You select the medium level.");
            return 8;
        } else {
            System.out.println("You select the hard level.");
            return 15;
        }
    }

    //Select the direction to move
    //N for moving north
    //S for moving south
    //E for moving East
    //W for moving West
    public String userSelectedDirection(){
        char myDirection = '\0';
        String myUserDirection = "";

        System.out.println("The direction option: \n" +
                "Type N for moving North\n" +
                "Type S for moving South\n" +
                "Type E for moving East\n" +
                "Type W for moving West\n" +
                "Please select the direction that you want to move:");
        myUserDirection = myUserInput.nextLine();
        myDirection = myUserDirection.toUpperCase().charAt(0); //For the case that the user input the lower case

        while( myDirection != 'N' && myDirection != 'S' && myDirection != 'E' && myDirection != 'W') {
            System.out.println(myDirection + " is invalid option, please select the direction (N, S, E, W):");
            myUserDirection = myUserInput.nextLine();
            myDirection = myUserDirection.toUpperCase().charAt(0);
        }
        return String.valueOf(myDirection);
    }

    //Display the trivia question form the database
    public void displayTriviaQuestion() {
        Trivia currentQuestion = Database.getQuestionList().get(0);

        //Display the randomly question form database
        System.out.println(currentQuestion.getQuestion());

        //Create the option of the random question
        //There are 2 kinds of question sets: Multiple choices and True/False question
        //To display in the console for the multiple choice question
        // System.out.println("Options: " + Arrays.toString(currentQuestion.getOptions()));
        String[] answerOption = currentQuestion.getOptions();
        if (answerOption.length == 4){
            System.out.println("A. " + answerOption[0]);
            System.out.println("B. " + answerOption[1]);
            System.out.println("C. " + answerOption[2]);
            System.out.println("D. " + answerOption[3]);
        } else {
            System.out.println(answerOption[0]);
            System.out.println(answerOption[1]);
        }

        //Checking the answer
        //We will using GUI to display this so we can avoid the invalid answer
        //char myAnswer = '\0';
        String myUserAnswer = "";
        System.out.println("Please select your answer ");
        myUserAnswer = myUserInput.nextLine();
        //myAnswer = myUserAnswer.toUpperCase().charAt(0);
        if ( myUserAnswer.equals(currentQuestion.getAnswer())) {
            System.out.println("Your answer is RIGHT!!!");
            //open the door
        } else {
            System.out.println("Your answer is WRONG!! The right answer is " + currentQuestion.getAnswer());
            //close the door
        }
        //System.out.println("Answer: " + currentQuestion.getAnswer());
    }

    // The message for the winning player
    public void displayWinningMessage() {
        System.out.println("Congratulation " + myUserName + ", You Win!!");
        //display the playing time
        //button to close or start the new game
    }

    // The message when losing the same
    public void displayLosingMessage() {
        System.out.println("Sorry " + myUserName + ", You lose!! Let's try it again!!");
        //button to close or start the new game
    }

    //close the Scanner after use it
    public void closeScanner() {
        this.myUserInput.close();
    }
}
