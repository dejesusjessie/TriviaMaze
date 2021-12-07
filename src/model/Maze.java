package model;

import java.awt.Point;

/**
 * The Maze class
 * @author Kannika Armstrong
 * @version Fall 2021
 */

public class Maze {

    private int myPlayerRow; // current row of the maze
    private int myPlayerColumn; // current column of the maze
    private Room[][] rooms; // create each room in the maze by using grid point
    private int dimension; // dimension of the maze

    // Maze constructor
    public Maze() {
        this.myPlayerRow = 0;
        this.myPlayerColumn = 0;
    }

    // Getter and setter of the room
    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] theRooms) {
        this.rooms = theRooms;
    }

    // Getter and setter of the dimension of the room
    public int getDimension() {
        return dimension;
    }

    public void setDimension(int theDimension) {
        this.dimension = theDimension;
    }

    // toString method --> print out the maze
    @Override
    public String toString() {
        Room room = this.rooms[this.myPlayerRow][this.myPlayerColumn];
        StringBuilder maze = new StringBuilder();
        int i, j;

        for (i = 0; i < this.rooms.length; i++) {
            // build north doors
            for (j = 0; j < this.rooms[i].length; j++) {
                maze.append("+"); // the corner of the room
                    if (this.rooms[i][j].getMyNorthDoor().isLocked()) {
                        maze.append("x"); // print x when the door is locked on the north
                    } else if (this.rooms[i][j].getMyNorthDoor().isOpen()) {
                        maze.append(" ");
                    } else{
                        maze.append("-"); // print the door on the north
                    }
            }
            maze.append("+\n"); // the right corner

            // build west doors
            for (j = 0; j < this.rooms[i].length; j++) {
                    if(this.rooms[i][j].getMyWestDoor().isLocked()) {
                        maze.append("x"); // print x when the door is locked on the west
                    } else if (this.rooms[i][j].getMyWestDoor().isOpen()){
                        maze.append(" ");
                    } else {
                        maze.append("|"); // print the west door
                    }

                // in the room space
                if(this.rooms[i][j].isExitRoom()) {
                    maze.append("E"); // Exit room at the bottom right corner
                } else if(i == this.myPlayerRow && j == this.myPlayerColumn) {
                    maze.append("P"); // Represent the player position
                } else {
                    maze.append(" "); // Empty room
                }
            }
            if(this.rooms[i][j-1].getMyEastDoor().isLocked()) {
                maze.append("x"); // print x when the door is locked on the west
            } else if (this.rooms[i][j-1].getMyEastDoor().isOpen()) {
                maze.append(" ");
            } else {
                maze.append("|");
            }
            //maze.append("W"); // print the east door
            maze.append("\n"); // go to the next line after print the last east door
        }

        // build south door
        for (j = 0; j < this.rooms[0].length; j++){
            maze.append("+"); // the corner of the room
            if(this.rooms[this.rooms.length-1][j].getMySouthDoor().isLocked()) {
                maze.append("x"); // print x when the door is locked on the west
            } else if (this.rooms[this.rooms.length-1][j].getMySouthDoor().isOpen()) {
                maze.append(" ");
            } else {
                maze.append("-");
            }
        }
        maze.append("+\n"); // the corner on the bottom right of the maze
        return maze.toString();
    }

    ////////////////////////////////////////////////////////////////////////////
    /////             Game controlling -> Moving/Changing room             /////
    ////////////////////////////////////////////////////////////////////////////

    // moving to the north
    public void moveNorth() {
        Room currentRoom = this.rooms[this.myPlayerRow][this.myPlayerColumn];
        if(currentRoom.getMyNorthDoor().canEnter()) { // If canEnter to the north room
            this.myPlayerRow--;
            if(this.myPlayerRow <= 0) {
                this.myPlayerRow = this.rooms.length - 1;
            }
        } else {
            System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the south
    public void moveSouth() {
        Room currentRoom = this.rooms[this.myPlayerRow][this.myPlayerColumn];
        if(currentRoom.getMySouthDoor().canEnter()) { // If canEnter to the south room
            this.myPlayerRow++;
            if (this.myPlayerRow >= this.rooms.length) {
                this.myPlayerRow = 0;
            }
        } else {
            System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the east
    public void moveEast() {
        Room currentRoom = this.rooms[this.myPlayerRow][this.myPlayerColumn];
        if(currentRoom.getMyEastDoor().canEnter()) { // If canEnter to the east room
            this.myPlayerColumn++;
            if(this.myPlayerColumn >= this.rooms.length) {
                this.myPlayerColumn = 0;
            };
        } else {
            System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the west
    public void moveWest() {
        Room curRoom = this.rooms[this.myPlayerRow][this.myPlayerColumn];
        if(curRoom.getMyWestDoor().canEnter()) { // If canEnter to the west room
            this.myPlayerColumn--;
            if (this.myPlayerColumn <= 0) {
                this.myPlayerColumn = this.rooms.length - 1;
            }
        }else {
            System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // When the player can reach the exit room --> exit the game
    public boolean reachExit() {
        return this.rooms[this.myPlayerRow][this.myPlayerColumn].isExitRoom();
    }

    // Get the position
    public Point getPosition() {
        return new Point(this.myPlayerRow, this.myPlayerRow);
    }

    // Get the current room position
    public Room getCurrentRoom() {
        return this.rooms[this.myPlayerRow][this.myPlayerColumn];
    }
    ////////////////////////////////////////////////////////////////////////////
    /////                   Maze Solving / Maze Traversal                  /////
    ////////////////////////////////////////////////////////////////////////////

    public boolean mazeTraversal() {
        boolean[][] mazeGrid = new boolean[this.dimension][this.dimension];
        for(int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                mazeGrid[i][j] = false;
            }
        }
        mazeTraversHelper(this.myPlayerRow, this.myPlayerColumn, mazeGrid);
        return mazeGrid[this.dimension - 1][this.dimension - 1];
    }

    //
    public void mazeTraversHelper(int theRow, int theColumn, boolean[][] theMazeGrid) {
        Room currentRoom = this.rooms[theRow][theColumn];
        theMazeGrid[theRow][theColumn] = true;
        if(currentRoom.isExitRoom()) { //if the player is in the exit room
            return;
        }
        // set all direction around current position
        int northRow = theRow - 1, northColumn = theColumn,
                southRow = theRow + 1, southColumn = theColumn,
                eastRow = theRow, eastColumn = theColumn + 1,
                westRow = theRow, westColumn = theColumn - 1;

        if(northRow < 0)
            northRow = this.dimension -1;
        if(southRow >= this.dimension)
            southRow = 0;
        if(eastColumn >= this.dimension)
            eastColumn = 0;
        if(westColumn < 0)
            westColumn = this.dimension -1;

        // Traversal helper
        if(!currentRoom.getMyNorthDoor().isLocked() && !theMazeGrid[northRow][theColumn]) {
            mazeTraversHelper(northRow, theColumn, theMazeGrid);
        }
        if(!currentRoom.getMySouthDoor().isLocked() && !theMazeGrid[southRow][theColumn]) {
            mazeTraversHelper(southRow, theColumn, theMazeGrid);
        }
        if(!currentRoom.getMyEastDoor().isLocked() && !theMazeGrid[theRow][eastColumn]) {
            mazeTraversHelper(theRow, eastColumn, theMazeGrid);
        }
        if(!currentRoom.getMyWestDoor().isLocked() && !theMazeGrid[theRow][westColumn]) {
            mazeTraversHelper(theRow, westColumn, theMazeGrid);
        }
    }
    /**
     *
     * @return
     */
    public String toGUI() {

        Room room = this.rooms[this.myPlayerRow][this.myPlayerColumn];
        StringBuilder maze = new StringBuilder();
        int i, j;
        

        for (i = 0; i < this.rooms.length; i++) {
            // build north doors
            for (j = 0; j < this.rooms[i].length; j++) {
                maze.append("+"); // the corner of the room
                if (i == 0){
                    maze.append("W"); // build the wall
                    
                } else {
                    if(this.rooms[i][j].getMyNorthDoor().isLocked()) {
                        maze.append("b"); // print x when the door is locked on the north
                    } else if(this.rooms[i][j].getMyNorthDoor().isOpen()){
                    	maze.append("k");
                    }
                    else {
                        maze.append("-"); // print the door on the north
                    }
                }
            }
            maze.append("+n"); // the right corner

            // build west doors
            for (j = 0; j < this.rooms[i].length; j++) {
                if (j == 0){
                    maze.append("V"); // build the wall
                } else {
                    if(this.rooms[i][j].getMyWestDoor().isLocked()) {
                        maze.append("x"); // print x when the door is locked on the west
                    } else if(this.rooms[i][j].getMyWestDoor().isOpen()){
                    	maze.append("o");
                    }
                    	else {
                        maze.append("|"); // print the west door
                    }
                }

                // in the room space
                if(this.rooms[i][j].isExitRoom()) {
                    maze.append("e"); // Exit room at the bottom right corner
                } else if(i == this.myPlayerRow && j == this.myPlayerColumn) {
                    maze.append("P"); // Represent the player position
                } else {
                    maze.append(" "); // Empty room
                }
            }

            maze.append("E"); // print the east wall
            maze.append("n"); // go to the next line after print the last east door
        }

        // build south wall
        for (j = 0; j < this.rooms[0].length; j++){
            maze.append("+"); // the corner of the room
            maze.append("W"); // print the door on the south
        }
        maze.append("+n"); // the corner on the bottom right of the maze
        return maze.toString();

    }

    
    public void setWalls() {
    	for (int j = 0; j < this.rooms.length; j++) {
    		this.rooms[0][j].setNIsWall();
    		this.rooms[j][0].setWIsWall();
    	}
    	for (int j = 0; j < this.rooms.length; j++) {
    		this.rooms[this.rooms.length-1][j].setSIsWall();
    		this.rooms[j][this.rooms.length-1].setEIsWall();
    	}

    }
}