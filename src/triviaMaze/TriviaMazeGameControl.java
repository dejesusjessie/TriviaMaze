package triviaMaze;

// Not finished yet
import io.Database;
import io.Trivia;
import maze.Maze;
import maze.MazeBuilder;
import maze.Room;

public class TriviaMazeGameControl {

    public TriviaMazeGameControl(){
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
                    System.out.println("Welcome to the next room!");
                } else {
                    lockDoor(myMazeGame, myDirection);
                }
            }

        } while (myMazeGame.mazeTraversal() && !myMazeGame.reachExit());
    }

    private static void openDoor(Room currentRoom, String direction) {
        if(direction.equalsIgnoreCase("N"))
            currentRoom.getNorthDoor().open();
        else if(direction.equalsIgnoreCase("S"))
            currentRoom.getSouthDoor().open();
        else if(direction.equalsIgnoreCase("E"))
            currentRoom.getEastDoor().open();
        else
            currentRoom.getWestDoor().open();
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
            return currentRoom.getNorthDoor().isOpen();
        } else if (direction.equalsIgnoreCase("S")) {
            return currentRoom.getSouthDoor().isOpen();
        } else if (direction.equalsIgnoreCase("E")) {
            return currentRoom.getEastDoor().isOpen();
        } else {
            return currentRoom.getWestDoor().isOpen();
        }
    }

    private static void wallLocked(String direction, Room currentRoom) {
        if (direction.equalsIgnoreCase("N")) {
            currentRoom.lockNorth();
        } else if (direction.equalsIgnoreCase("S")) {
            currentRoom.lockSouth();
        } else if (direction.equalsIgnoreCase("E")) {
            currentRoom.lockEast();
        } else {
            currentRoom.lockWest();
        }
    }

    private static boolean doorController (String direction, Room currentRoom) {
        if (direction.equalsIgnoreCase("N")) {
            return currentRoom.getNorthDoor().canEnter();
        } else if (direction.equalsIgnoreCase("S")) {
            return currentRoom.getSouthDoor().canEnter();
        } else if (direction.equalsIgnoreCase("E")) {
            return currentRoom.getEastDoor().canEnter();
        } else {
            return currentRoom.getWestDoor().canEnter();
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
