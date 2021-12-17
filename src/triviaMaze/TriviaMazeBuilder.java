package triviaMaze;

/**
 *
 * @author Kannika Armstrong
 * @version Fall 2021
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
        Room myCurrentRoom; // create the current room
        String myDirection; //
        String myAnswer;

        //If the player still can move and does not reach the exit
        do {
            myCurrentRoom = myMazeGame.getCurrentRoom();
            System.out.println(myMazeGame.toString()); // print out the maze

            // When the player
            do {
                myDirection = promptUser.userSelectedDirection();
                if (!doorController(myDirection, myCurrentRoom)) {
                    System.out.println("This door is locked. Please try the other way.");
                }
            } while(!doorController( myDirection, myCurrentRoom));

            if (!doorOpened(myDirection, myCurrentRoom)) {
                myAnswer = promptUser.displayTrivia();
                if (myAnswer.equals("Correct")){
                    movePlayer(myMazeGame,myDirection);
                    openDoor(myCurrentRoom, myDirection);
                    //System.out.println("Welcome to the next room!");
                } else {
                    lockDoor(myMazeGame, myDirection);
                }
            } else {
                movePlayer(myMazeGame,myDirection);
            }

        } while (myMazeGame.mazeTraversal() && !myMazeGame.reachExit());

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

            Room myCurrentRoom = data.getCurrentRoom(); // create the current room
            String myDirection = data.getDirection(); //
            String myAnswer;
            this.myMazeGame = data.getMyMazeGame();
            //this.myPlayerDirection = data.getDirection();
            //this.myPlayerCurrentRoom = data.getCurrentRoom();
            System.out.println("----- Loading Game Successful!! -----");

            //String myAnswer;
            PromptUser promptUser = new PromptUser();
            do {
                myCurrentRoom = myMazeGame.getCurrentRoom();
                System.out.println(myMazeGame.toString()); // print out the maze

                // When the player
                do {
                    myDirection = promptUser.userSelectedDirection();
                    if (!doorController(myDirection, myCurrentRoom)) {
                        System.out.println("This door is locked. Please try the other way.");
                    }
                } while(!doorController( myDirection, myCurrentRoom));

                if (!doorOpened(myDirection, myCurrentRoom)) {
                    myAnswer = promptUser.displayTrivia();
                    if (myAnswer.equals("Correct")){
                        movePlayer(myMazeGame,myDirection);
                        openDoor(myCurrentRoom, myDirection);
                    } else {
                        lockDoor(myMazeGame, myDirection);
                    }
                } else {
                    movePlayer(myMazeGame,myDirection);
                }

            } while (myMazeGame.mazeTraversal() && !myMazeGame.reachExit());

            if (myMazeGame.reachExit()){
                promptUser.displayWinningMessage();
            } else {
                promptUser.displayLosingMessage();
            }
        } catch (Exception exception){
            System.out.println("Serialization Error! Can't save the game.");
        }
    }
}
