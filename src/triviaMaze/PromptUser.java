package triviaMaze;

import java.util.Locale;
import java.util.Scanner;

public class PromptUser {

    private Scanner myUserInput; // use to take all input from the user

    // The PromptUser constructor
    public PromptUser(){
        this.myUserInput = new Scanner(System.in); //get the input from the user
    }

    //Return the username
    //Take username from the player input and return it
    public String userName() {
        String myUserName = ""; //Initial to empty string

        System.out.println("Please enter your username: ");
        myUserName = myUserInput.nextLine();

        //The player have to create the username.
        while (myUserName.isEmpty()){
            System.out.println("You did not enter your username, please enter your username:");
            myUserName = myUserInput.nextLine();
        }

        System.out.println("Welcome " + myUserName +  " to the Husky Trivia Maze Game.");

        return myUserName;
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
}
