package triviaMaze;

// Not finished yet 
import io.Trivia;
import maze.Maze;
import maze.Room;

public class TriviaMazeGameControl {

    private Maze myMazeGame;
    private PromptUser myPromptUser;
    private Trivia myCurrentQuestion;


    // Game start controller
    public void gameStartController() {
        Room myCurrentRoom; // create the current room
        String myDirection; //
        String myAnswer;
        String myCorrectAnswer;

        //If the player still can move and does not reach the exit
        do {
            myCurrentRoom = myMazeGame.getCurrentRoom();
            System.out.println(myMazeGame.toString()); // print out the maze

            // When the player
            do {
                myDirection = myPromptUser.userSelectedDirection();
                System.out.println("This door is locked. Please try the other way.");
            } while(!doorController( myDirection, myCurrentRoom));

            if (!doorOpened(myDirection, myCurrentRoom)) {
                myCorrectAnswer = this.myCurrentQuestion.getAnswer();
            }

        } while (myMazeGame.mazeTraversal() && !myMazeGame.reachExit());
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


}
