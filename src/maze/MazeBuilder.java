package maze;

public class MazeBuilder {
    private final int dimension;

    // The MazeBuilder constructor -> default 4 by 4 maze
    public MazeBuilder() {
        this(4);
    }

    // The MazeBuilder constructor -> the player can choose the dimension of the Maze
    public MazeBuilder(int dimension) {
        this.dimension = dimension;
    }

    // Create the build function to build the room
    public Maze buildRoom() {
        Maze maze = new Maze();
        maze.setRooms(this.roomSetup());
        maze.setDimension(this.dimension);
        return maze;
    }

    // setup the room for the maze
    private Room[][] roomSetup() {
        Room[][] rooms = new Room[this.dimension][this.dimension];

        // Initializing Rooms
        int i, j;
        for (i = 0; i < this.dimension; i++) {
            for (j = 0; j < this.dimension; j++) {
                rooms[i][j] = new Room();
            }
        }
        this.doorSetup(rooms);
        rooms[this.dimension - 1][this.dimension - 1].setExit();
        return rooms;
    }

    // set up the door to help to set up the room
    private void doorSetup(Room[][] rooms) {
        int i, j;

        // connect the west door and the east door (shared door)
        for (i = 0; i < this.dimension; i++) {
            rooms[i][0].setWestDoor(new Door());
            rooms[i][0].setEastDoor(new Door());
        }
        for (i = 0; i < this.dimension; i++)
            for (j = 1; j < this.dimension; j++) {
                rooms[i][j].setWestDoor(rooms[i][j - 1].getEastDoor());

                if (j == this.dimension - 1)
                    rooms[i][j].setEastDoor(rooms[i][0].getWestDoor());
                else
                    rooms[i][j].setEastDoor(new Door());
            }

        // connect the north door and the south door (shared door)
        for (i = 0; i < this.dimension; i++) {
            rooms[0][i].setNorthDoor(new Door());
            rooms[0][i].setSouthDoor(new Door());
        }
        for (i = 1; i < this.dimension; i++)
            for (j = 0; j < this.dimension; j++) {
                rooms[i][j].setNorthDoor(rooms[i - 1][j].getSouthDoor());

                if (i == this.dimension - 1)
                    rooms[i][j].setSouthDoor(rooms[0][j].getNorthDoor());
                else
                    rooms[i][j].setSouthDoor(new Door());
            }
    }
}