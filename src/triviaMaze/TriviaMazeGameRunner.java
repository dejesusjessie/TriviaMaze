package triviaMaze;

/**
 *
 * @author Kannika Armstrong
 * @version Fall 2021
 *
 */

import model.Maze;
import model.MazeBuilder;

import java.util.Scanner;

public class TriviaMazeGameRunner {

    private final Scanner myUserInput; // use to take all input from the user
    private final TriviaMazeBuilder myPlayerGameBuilder;

    public TriviaMazeGameRunner(){
        this.myUserInput = new Scanner(System.in); // get the input from the user
        this.myPlayerGameBuilder = new TriviaMazeBuilder();
    }

    public void gameRunner(){
        char myOption = '\0';
        String myUserOption = "";

        System.out.println("Welcome to Husky Trivia Maze Game.");
        System.out.println("Select Your Option:");
        System.out.println("N -- New Game\n" +
                "L -- Load Game\n" +
                "E -- Exit Game");

        myUserOption = myUserInput.nextLine();
        myOption = myUserOption.toUpperCase().charAt(0);

        while (myOption != 'N' && myOption != 'L' && myOption != 'E'){
            System.out.println(myOption + " is invalid option, please select the option (N, L, E):");
            myUserOption = myUserInput.nextLine();
            myOption = myUserOption.toUpperCase().charAt(0);
        }

        switch (myOption){
            case ('N'):
                gameInitial();
                break;
            case ('L'):
                myPlayerGameBuilder.loadGame();
                break;
            case ('E'):
                System.exit(0);
                break;
            default:
                System.out.println("Wrong Option!");
        }
    }

    private void gameInitial(){
        PromptUser promptUser = new PromptUser();
        String username = promptUser.userName(); // create username
        int myMazeSize = promptUser.userMazeSize(); // get the maze size
        //
        MazeBuilder mazeBuilder = new MazeBuilder(myMazeSize);
        Maze myMazeGame = mazeBuilder.buildRoom();

        myPlayerGameBuilder.gameStartController(myMazeGame, promptUser);

        promptUser.closeScanner();
    }

    // Close the Scanner after use it
    private void closeScanner() {
        this.myUserInput.close();
    }

}
