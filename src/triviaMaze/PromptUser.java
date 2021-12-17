package triviaMaze;

import io.Database;
import io.Trivia;

import java.util.Scanner;

/**
 * The prompt user -- console game.
 * @author Kannika Armstrong
 * @version Fall 2021
 *
 */

public class PromptUser {

    private final Scanner myUserInput; // use to take all input from the user
    private String myUserName; // the username

    // The PromptUser constructor
    public PromptUser(){
        this.myUserInput = new Scanner(System.in); // get the input from the user
        this.myUserName = ""; // Initial to empty string
    }

    public String getMyUserName() {
        return myUserName;
    }

    public void setMyUserName(String myUserName) {
        this.myUserName = myUserName;
    }

    // Return the username
    // Take username from the player input and return it
    public String userName() {

        System.out.println("Please enter your username: ");
        this.myUserName = myUserInput.nextLine();

        // The player have to create the username.
        while (this.myUserName.isEmpty()){
            System.out.println("You did not enter your username, please enter your username:");
            this.myUserName = myUserInput.nextLine();
        }

        System.out.println("Welcome " + this.myUserName +  " to the Husky Trivia Maze Game.");

        return this.myUserName;
    }
    
    // There are three three difficulty level for the game:
    // B for Beginner game: 4x4 maze
    // M for Medium game: 8x8 maze
    // H for Hard game: 15x15 maze
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
        myLevel = myUserLevel.toUpperCase().charAt(0); // For the case that the user input the lower case

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

    // Select the direction to move
    // N for moving north
    // S for moving south
    // E for moving East
    // W for moving West
    public String userSelectedDirection(){
        char myDirection = '\0';
        String myUserDirection = "";

        System.out.println("The game options: \n" +
                "Type N for moving North\n" +
                "Type S for moving South\n" +
                "Type E for moving East\n" +
                "Type W for moving West\n" +
                "Type G for exit with saving game\n" +
                "Type Q for exit without saving game\n" +
                "Please select your option:");
        myUserDirection = myUserInput.nextLine();
        myDirection = myUserDirection.toUpperCase().charAt(0); // For the case that the user input the lower case

        while( myDirection != 'N' && myDirection != 'S' && myDirection != 'E' && myDirection != 'W'
                && myDirection != 'G' && myDirection != 'Q') {
            System.out.println(myDirection + " is invalid option, please select your option (N, S, E, W, G, or Q):");
            myUserDirection = myUserInput.nextLine();
            myDirection = myUserDirection.toUpperCase().charAt(0);
        }
        if (myDirection == 'N') {
            System.out.println("You want to go North.");
        } else if ( myDirection == 'S') {
            System.out.println("You want to go South.");
        } else if ( myDirection == 'W') {
            System.out.println("You want to go West.");
        } else if ( myDirection == 'E') {
            System.out.println("You want to go East.");
        } else if ( myDirection == 'G') {
            System.out.println("Save your game.");
        } else {
            System.out.println("Quit your game.");
        }
        return String.valueOf(myDirection);
    }

    // Display the trivia question form the database and return the user answer
    public String displayTrivia() {
        Trivia currentQuestion = Database.getQuestionList().get(0);

        // Display the randomly question form database
        System.out.println(currentQuestion.getQuestion());

        // Create the option of the random question
        // There are 2 kinds of question sets: Multiple choices and True/False question
        // To display in the console for the multiple choice question
        String[] answerOption = currentQuestion.getOptions();
        if (answerOption.length == 4){
            System.out.println("A. " + answerOption[0]);
            System.out.println("B. " + answerOption[1]);
            System.out.println("C. " + answerOption[2]);
            System.out.println("D. " + answerOption[3]);
        } else {
            System.out.print(answerOption[0]);
            System.out.print(" or ");
            System.out.println(answerOption[1]);
        }

        // Checking the answer
        String userAnswer = ""; // take the user input
        String myUserAnswer = ""; // convert to uppercase to check answer
        String myResult = "";
        System.out.println("Please select your answer ");
        userAnswer = myUserInput.nextLine();
        myUserAnswer = userAnswer.toUpperCase();

        while(!myUserAnswer.equals("A") && !myUserAnswer.equals("B") && !myUserAnswer.equals("C") && !myUserAnswer.equals("D")
                && !myUserAnswer.equals("TRUE") && !myUserAnswer.equals("FALSE")) {
            if (answerOption.length == 4) {
                System.out.println(userAnswer + " is invalid option, please select the direction (A, B, C, or D):");
                userAnswer = myUserInput.nextLine();
                myUserAnswer = userAnswer.toUpperCase();
            } else {
                System.out.println(userAnswer + " is invalid option, please select the direction (True or False):");
                userAnswer = myUserInput.nextLine();
                myUserAnswer = userAnswer.toUpperCase();
            }
        }
        if (myUserAnswer.equals(currentQuestion.getAnswer().toUpperCase())) {
            System.out.println("Your answer is RIGHT!!!");
            myResult = "Correct";
        } else {
            System.out.println("Your answer is WRONG!! The right answer is " + currentQuestion.getAnswer());
            myResult = "Wrong";
        }
        return myResult;
    }

    // The message for the winning player
    public void displayWinningMessage() {
        System.out.println("Congratulation " + myUserName + ", You Win!!");
    }

    // The message when losing the same
    public void displayLosingMessage() {
        System.out.println("Sorry " + myUserName + ", You lose!! Let's try it again!!");
    }

    // Close the Scanner after use it
    public void closeScanner() {
        this.myUserInput.close();
    }
}
