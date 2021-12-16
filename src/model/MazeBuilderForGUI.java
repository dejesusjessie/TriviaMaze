package model;

import java.io.Serializable;

public class MazeBuilderForGUI implements Serializable {
    /**
	 * The serial version number.
	 */
	private static final long serialVersionUID = 360754658392284934L;
	
	private final int myDimension;

    // The MazeBuilder constructor -> default 4 by 4 maze
    public MazeBuilderForGUI() {
        this(4);
    }

    // The MazeBuilder constructor -> the player can choose the dimension of the Maze
    public MazeBuilderForGUI(int dimension) {
        this.myDimension = dimension;
    }

    // Create the build function to build the room
    public MazeForGUI buildRoom() {
        MazeForGUI maze = new MazeForGUI();
        maze.setRooms(this.roomSetup());
        maze.setDimension(this.myDimension);
        return maze;
    }

    // setup the room for the maze
    private Room[][] roomSetup() {
        Room[][] rooms = new Room[this.myDimension][this.myDimension];

        // Initializing Rooms
        int i, j;
        for (i = 0; i < this.myDimension; i++) {
            for (j = 0; j < this.myDimension; j++) {
                rooms[i][j] = new Room();
            }
        }
        this.doorSetup(rooms);
        rooms[this.myDimension - 1][this.myDimension - 1].setExit();
        return rooms;
    }

    // set up the door to help to set up the room
    private void doorSetup(Room[][] rooms) {
        int i, j;

        // connect the west door and the east door (shared door)
        for (i = 0; i < this.myDimension; i++) {
//            rooms[i][0].setWestWall(new Door());
//            rooms[i][0].setEastWall(new Door());
            rooms[i][0].setMyWestDoor(new Door());
            rooms[i][0].setMyEastDoor(new Door());
        }
        for (i = 0; i < this.myDimension; i++)
            for (j = 1; j < this.myDimension; j++) {
                rooms[i][j].setMyWestDoor(rooms[i][j - 1].getMyEastDoor());

                if (j == this.myDimension - 1)
                    rooms[i][j].setMyEastDoor(rooms[i][0].getMyWestDoor());
                else
                    rooms[i][j].setMyEastDoor(new Door());
            }

        // connect the north door and the south door (shared door)
        for (i = 0; i < this.myDimension; i++) {
//            rooms[0][i].setNorthWall(new Door());
//            rooms[0][i].setSouthWall(new Door());
            rooms[0][i].setMyNorthDoor(new Door());
            rooms[0][i].setMySouthDoor(new Door());
        }
        for (i = 1; i < this.myDimension; i++)
            for (j = 0; j < this.myDimension; j++) {
                rooms[i][j].setMyNorthDoor(rooms[i - 1][j].getMySouthDoor());

                if (i == this.myDimension - 1)
                    rooms[i][j].setMySouthDoor(rooms[0][j].getMyNorthDoor());
                else
                    rooms[i][j].setMySouthDoor(new Door());
            }
    }
}