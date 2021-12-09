package triviaMaze;

/**
 *
 * @author Kannika Armstrong
 *
 */

import io.ConsoleGameData;
import io.ResourceManager;
import model.Maze;
import model.Room;

import java.io.*;

public class TriviaMazeBuilder implements Serializable {

    private static final long serialVersionUID = -4779440637839610947L;
    private Maze myMazeGame;
    private String myPlayerDirection;
    private Room myPlayerCurrentRoom;


    public TriviaMazeBuilder(){
        this.myMazeGame = new Maze();
        this.myPlayerDirection = "";
        this.myPlayerCurrentRoom = new Room();

    }

    // Game start controller
    void gameStartController(Maze myMazeGame, PromptUser promptUser) {
        playGame(myMazeGame, promptUser);
        endGame(myMazeGame, promptUser);
    }

    // during playing game
    private void playGame(Maze mazeGame, PromptUser promptUser) {
        String myAnswer;
        this.myMazeGame = mazeGame;
        runState(promptUser);
        endGame(myMazeGame,promptUser);
    }


    //display text when end the game, winning and losing message
    private void endGame(Maze myMazeGame, PromptUser promptUser) {
        if (myMazeGame.reachExit()){
            promptUser.displayWinningMessage();
        } else {
            promptUser.displayLosingMessage();
        }
    }

    //
    private static void openDoor(Room currentRoom, String direction) {
        if(direction.equalsIgnoreCase("N"))
            currentRoom.getMyNorthDoor().open();
        else if(direction.equalsIgnoreCase("S"))
            currentRoom.getMySouthDoor().open();
        else if(direction.equalsIgnoreCase("E"))
            currentRoom.getMyEastDoor().open();
        else
            currentRoom.getMyWestDoor().open();
    }


    // lock the door

    private static void lockDoor(Maze myMazeGame, String direction) {
        Room currentRoom = myMazeGame.getCurrentRoom();

        if (direction.equalsIgnoreCase("N"))
            currentRoom.lockNorth();
        else if (direction.equalsIgnoreCase("S"))
            currentRoom.lockSouth();
        else if (direction.equalsIgnoreCase("E"))
            currentRoom.lockEast();
        else
            currentRoom.lockWest();
    }


     // if the door opened

    private static boolean doorOpened(String direction, Room currentRoom) {
        if (direction.equalsIgnoreCase("N")) {
            return currentRoom.getMyNorthDoor().isOpen();
        } else if (direction.equalsIgnoreCase("S")) {
            return currentRoom.getMySouthDoor().isOpen();
        } else if (direction.equalsIgnoreCase("E")) {
            return currentRoom.getMyEastDoor().isOpen();
        } else {
            return currentRoom.getMyWestDoor().isOpen();
        }
    }

    /*
    * Control the door, check can enter those door or not
     */
    private static boolean doorController (String direction, Room currentRoom) {
        if (direction.equalsIgnoreCase("N")) {
            return currentRoom.getMyNorthDoor().canEnter();
        } else if (direction.equalsIgnoreCase("S")) {
            return currentRoom.getMySouthDoor().canEnter();
        } else if (direction.equalsIgnoreCase("E")) {
            return currentRoom.getMyEastDoor().canEnter();
        } else {
            return currentRoom.getMyWestDoor().canEnter();
        }
    }


    // Moving the player when can move

    private static void movePlayer(Maze myMazeGame, String direction) {
        if (direction.equalsIgnoreCase("N"))
            myMazeGame.moveNorth();
        else if (direction.equalsIgnoreCase("S"))
            myMazeGame.moveSouth();
        else if (direction.equalsIgnoreCase("E"))
            myMazeGame.moveEast();
        else
            myMazeGame.moveWest();
    }


    // saving game

    private static void saveGame(Maze myMazeGame, String direction, Room currentRoom) {
        ConsoleGameData data = new ConsoleGameData(myMazeGame, direction, currentRoom);
        try {
            ResourceManager.save(data);
            System.out.println("----- Saving Game Successful!! -----");
        } catch (Exception exception) {
            System.out.println("Serialization Error! Can't save the game.");
        }
    }

    // loading game
    void loadGame(){
        try {
            ConsoleGameData data = (ConsoleGameData) ResourceManager.load();
            this.myMazeGame = data.getMyMazeGame();
            this.myPlayerDirection = data.getDirection();
            this.myPlayerCurrentRoom = data.getCurrentRoom();
            System.out.println("----- Loading Game Successful!! -----");
            displayLoadGame(myMazeGame,myPlayerDirection,myPlayerCurrentRoom);
        } catch (Exception exception){
            System.out.println("Serialization Error! Can't save the game.");
        }
    }

    // Display game after load
    private void displayLoadGame(Maze mazeGame, String direction, Room currentRoom){
        String myAnswer;
        this.myMazeGame = mazeGame;
        PromptUser promptUser = new PromptUser();
        runState(promptUser);
    }

    // Use to run any state, both initial and load game
    private void runState(PromptUser promptUser) {
        String myAnswer;
        do {
            myPlayerCurrentRoom = myMazeGame.getCurrentRoom();
            System.out.println(myMazeGame.toString()); // print out the maze

            // When the player
            myPlayerDirection = promptUser.userSelectedDirection();
            if (myPlayerDirection.equalsIgnoreCase("G")) {
                saveGame(myMazeGame, myPlayerDirection, myPlayerCurrentRoom);
                System.exit(0);
            } else if (myPlayerDirection.equalsIgnoreCase("Q")){
                System.exit(0);
            } else {
                do {
                    if (!doorController(myPlayerDirection, myPlayerCurrentRoom)) {
                        System.out.println("This door is locked. Please try the other way.");
                    }
                } while (!doorController(myPlayerDirection, myPlayerCurrentRoom));
            }

            if (!doorOpened(myPlayerDirection, myPlayerCurrentRoom)) {
                myAnswer = promptUser.displayTrivia();
                if (myAnswer.equals("Correct")){
                    movePlayer(myMazeGame,myPlayerDirection);
                    openDoor(myPlayerCurrentRoom, myPlayerDirection);
                } else {
                    lockDoor(myMazeGame, myPlayerDirection);
                }
            } else {
                movePlayer(myMazeGame,myPlayerDirection);
            }
        } while (myMazeGame.mazeTraversal() && !myMazeGame.reachExit());
    }
}
