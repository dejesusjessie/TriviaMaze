package triviaMaze;

import java.util.Scanner;

public class PromptUser {

    private Scanner myUserInput; // use to take all input from the user

    // The PromptUser constructor
    public PromptUser(){
        this.myUserInput = new Scanner(System.in); //get the input from the user
    }

    //Return the username
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

}
