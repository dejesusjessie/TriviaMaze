package triviaMaze;

/**
 *
 * @author Kannika Armstrong
 *
 */

import model.Maze;
import model.MazeBuilder;
import model.Room;

public class TriviaMazeBuilder {

    public TriviaMazeBuilder(){
        gameRunner();
    }

    private void gameRunner(){
        PromptUser promptUser = new PromptUser();
        String username = promptUser.userName(); // create username
        int myMazeSize = promptUser.userMazeSize(); // get the maze size
        //
        MazeBuilder mazeBuilder = new MazeBuilder(myMazeSize);
        Maze myMazeGame = mazeBuilder.buildRoom();

        gameStartController(myMazeGame, promptUser);

        promptUser.closeScanner();
    }

    // Game start controller
    private void gameStartController(Maze myMazeGame, PromptUser promptUser) {
        Room myCurrentRoom; // create the current room
        String myDirection; //
        String myAnswer;

        playGame(myMazeGame, promptUser);
        endGame(myMazeGame, promptUser);
    }

    private void playGame(Maze myMazeGame, PromptUser promptUser) {
        String myDirection;
        String myAnswer;
        Room myCurrentRoom;
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
    }

    private void endGame(Maze myMazeGame, PromptUser promptUser) {
        if (myMazeGame.reachExit()){
            promptUser.displayWinningMessage();
        } else {
            promptUser.displayLosingMessage();
        }
    }

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
}
