package model;

/**
 * The Maze builder class
 * @author Kannika Armstrong
 * @version Fall 2021
 */

public class MazeBuilder {
    private final int myMazeDimension;

    // The MazeBuilder constructor -> default 4 by 4 maze
    public MazeBuilder() {
        this(4);
    }

    // The MazeBuilder constructor ->the dimension/size of the maze
    public MazeBuilder(int dimension) {
        this.myMazeDimension = dimension;
    }

    // Create the build function to build the room
    public Maze buildRoom() {
        Maze maze = new Maze();
        maze.setRooms(this.roomSetup());
        maze.setDimension(this.myMazeDimension);
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
    private void doorSetup(Room[][] rooms) {
        int i, j;

        // connect the west door and the east door
        for (i = 0; i < this.myMazeDimension; i++) {
            rooms[i][0].setWestDoor(new Door());
            rooms[i][0].setEastDoor(new Door());
        }
        for (i = 0; i < this.myMazeDimension; i++)
            for (j = 1; j < this.myMazeDimension; j++) {
                rooms[i][j].setWestDoor(rooms[i][j - 1].getEastDoor());

                if (j == this.myMazeDimension - 1)
                    rooms[i][j].setEastDoor(rooms[i][0].getWestDoor());
                else
                    rooms[i][j].setEastDoor(new Door());
            }

        // connect the north door and the south door
        for (i = 0; i < this.myMazeDimension; i++) {
            rooms[0][i].setNorthDoor(new Door());
            rooms[0][i].setSouthDoor(new Door());
        }
        for (i = 1; i < this.myMazeDimension; i++)
            for (j = 0; j < this.myMazeDimension; j++) {
                rooms[i][j].setNorthDoor(rooms[i - 1][j].getSouthDoor());

                if (i == this.myMazeDimension - 1)
                    rooms[i][j].setSouthDoor(rooms[0][j].getNorthDoor());
                else
                    rooms[i][j].setSouthDoor(new Door());
            }
    }
}