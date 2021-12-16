package model;

import java.io.Serializable;

/**
 * The Maze builder class
 * @author Kannika Armstrong
 * @version Fall 2021
 */

public class MazeBuilder implements Serializable {
    private final int myMazeDimension;

    // The MazeBuilder constructor -> default 4 by 4 maze
    public MazeBuilder() {
        this(4);
    }

    // The MazeBuilder constructor ->the dimension/size of the maze
    public MazeBuilder(int theDimension) {
        this.myMazeDimension = theDimension;
    }

    // Create the build function to build the room
    public Maze buildRoom() {
        Maze maze = new Maze();
        maze.setMyRooms(this.roomSetup());
        maze.setMyDimension(this.myMazeDimension);
        return maze;
    }

    // setup the room for the maze
    private Room[][] roomSetup() {
        Room[][] rooms = new Room[this.myMazeDimension][this.myMazeDimension];

        // Initializing Rooms
        int i, j;
        for (i = 0; i < this.myMazeDimension; i++) {
            for (j = 0; j < this.myMazeDimension; j++) {
                rooms[i][j] = new Room();
            }
        }
        this.doorSetup(rooms);
        rooms[this.myMazeDimension - 1][this.myMazeDimension - 1].setExit();
        return rooms;
    }

    // set up the door to help to set up the room
    private void doorSetup(Room[][] theRooms) {
        int i, j;

        // connect the west door and the east door
        for (i = 0; i < this.myMazeDimension; i++) {
            theRooms[i][0].setMyWestDoor(new Door());
            theRooms[i][0].setMyEastDoor(new Door());
        }
        for (i = 0; i < this.myMazeDimension; i++)
            for (j = 1; j < this.myMazeDimension; j++) {
                theRooms[i][j].setMyWestDoor(theRooms[i][j - 1].getMyEastDoor());

                if (j == this.myMazeDimension - 1)
                    theRooms[i][j].setMyEastDoor(theRooms[i][0].getMyWestDoor());
                else
                    theRooms[i][j].setMyEastDoor(new Door());
            }

        // connect the north door and the south door
        for (i = 0; i < this.myMazeDimension; i++) {
            theRooms[0][i].setMyNorthDoor(new Door());
            theRooms[0][i].setMySouthDoor(new Door());
        }
        for (i = 1; i < this.myMazeDimension; i++)
            for (j = 0; j < this.myMazeDimension; j++) {
                theRooms[i][j].setMyNorthDoor(theRooms[i - 1][j].getMySouthDoor());

                if (i == this.myMazeDimension - 1)
                    theRooms[i][j].setMySouthDoor(theRooms[0][j].getMyNorthDoor());
                else
                    theRooms[i][j].setMySouthDoor(new Door());
            }
    }
}