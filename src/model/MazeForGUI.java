package model;

import java.awt.Point;
import java.io.Serializable;

// Create the maze
public class MazeForGUI implements Serializable{

    /**
	 * The serial version number.
	 */
	private static final long serialVersionUID = -1441001006894431563L;
	
	int myRow; // number of rows of the maze
    int myColumn; // number of columns of the maze
    Room[][] myRooms; //create each room in the maze by using grip point
    int myDimension; // dimension of each room

    //Maze constructor
    public MazeForGUI() {

        this.myRow = 0;
        this.myColumn = 0;
    }

    // Getter and setter of the room
    public Room[][] getRooms() {
        return myRooms;
    }
    

    public Room getCurrentRooms() {
        return this.myRooms[this.myRow][this.myColumn];
    }

    public void setRooms(Room[][] rooms) {
        this.myRooms = rooms;
    }

    // Getter and setter of the dimension of the room
    public int getDimension() {
        return myDimension;
    }

    public void setDimension(int dimension) {
        this.myDimension = dimension;

    }

    // toString method --> print out the maze
    @Override
    public String toString() {
        Room room = this.myRooms[this.myRow][this.myColumn];
        StringBuilder maze = new StringBuilder();
        int i, j;

        for (i = 0; i < this.myRooms.length; i++) {
            // build north doors
            for (j = 0; j < this.myRooms[i].length; j++) {
                maze.append("+"); // the corner of the room
                    if (this.myRooms[i][j].getMyNorthDoor().isLocked()) {
                        maze.append("x"); // print x when the door is locked on the north
                    } else if (this.myRooms[i][j].getMyNorthDoor().isOpen()) {
                        maze.append(" ");
                    } else{
                        maze.append("-"); // print the door on the north
                    }
            }
            maze.append("+\n"); // the right corner

            // build west doors
            for (j = 0; j < this.myRooms[i].length; j++) {
                    if(this.myRooms[i][j].getMyWestDoor().isLocked()) {
                        maze.append("x"); // print x when the door is locked on the west
                    } else if (this.myRooms[i][j].getMyWestDoor().isOpen()){
                        maze.append(" ");
                    } else {
                        maze.append("|"); // print the west door
                    }

                // in the room space
                if(this.myRooms[i][j].isExitRoom()) {
                    maze.append("E"); // Exit room at the bottom right corner
                } else if(i == this.myRow && j == this.myColumn) {
                    maze.append("P"); // Represent the player position
                } else {
                    maze.append(" "); // Empty room
                }
            }
            if(this.myRooms[i][j-1].getMyEastDoor().isLocked()) {
                maze.append("x");
            } else if (this.myRooms[i][j-1].getMyEastDoor().isOpen()) {
                maze.append(" ");
            } else {
                maze.append("|");
            }
            //maze.append("W"); // print the east door
            maze.append("\n"); // go to the next line after print the last east door
        }

        // build south door
        for (j = 0; j < this.myRooms[0].length; j++){
            maze.append("+"); // the corner of the room
            if(this.myRooms[this.myRooms.length-1][j].getMySouthDoor().isLocked()) {
                maze.append("x");
            } else if (this.myRooms[this.myRooms.length-1][j].getMySouthDoor().isOpen()) {
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
        Room currentRoom = this.myRooms[this.myRow][this.myColumn];
        if(currentRoom.getMyNorthDoor().canEnter()) { // If canEnter to the north room
            this.myRow--;

            if(this.myRow <= 0) {
                this.myRow = 0; // make sure that the player cannot move through the wall
            }
            //currentRoom.getNorthDoor().lock();
        } else {
            //System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the south
    public void moveSouth() {
        Room currentRoom = this.myRooms[this.myRow][this.myColumn];
        if(currentRoom.getMySouthDoor().canEnter()) { // If canEnter to the south room
            this.myRow++;
            if (this.myRow >= this.myRooms.length) {

                this.myRow = this.myRooms.length - 1; // make sure that the player cannot move through the wall
            }
            //currentRoom.getSouthDoor().lock();
        } else {
            System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the east
    public void moveEast() {
        Room currentRoom = this.myRooms[this.myRow][this.myColumn];
        if(currentRoom.getMyEastDoor().canEnter()) { // If canEnter to the east room
            this.myColumn++;
            if(this.myColumn >= this.myRooms.length) {
                this.myColumn = this.myRooms.length - 1; // make sure that the player cannot move through the wall
            }
            //currentRoom.getEastDoor().lock();
        } else {
            //System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the west
    public void moveWest() {
        Room curRoom = this.myRooms[this.myRow][this.myColumn];
        if(curRoom.getMyWestDoor().canEnter()) { // If canEnter to the west room
            this.myColumn--;
            if (this.myColumn <= 0) {
//<<<<<<< HEAD
                this.myColumn = 0; // make sure that the player cannot move through the wall
//=======
//                this.column = this.rooms.length - 1;
//                //this.column = 0; // make sure that the player cannot move through the wall
//>>>>>>> a399629c79fecac35e9d70c373ae106703ca20f3
                //System.out.println("This is the wall! Please try the other way.");
            }
            //curRoom.getWestDoor().lock();
        }else {
            //System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // When the player can reach the exit room --> exit the game
    public boolean reachExit() {
        return this.myRooms[this.myRow][this.myColumn].isExitRoom();
    }

    // Get the position
    public Point getPosition() {
        return new Point(this.myRow, this.myRow);
    }

    // Get the current room position
    public Room getCurrentRoom() {
        return this.myRooms[this.myRow][this.myColumn];
    }
    ////////////////////////////////////////////////////////////////////////////
    /////                   Maze Solving / Maze Traversal                  /////
    ////////////////////////////////////////////////////////////////////////////

    public boolean mazeTraversal() {
        boolean[][] mazeGrid = new boolean[this.myDimension][this.myDimension];
        for(int i = 0; i < this.myDimension; i++) {
            for (int j = 0; j < this.myDimension; j++) {
                mazeGrid[i][j] = false;
            }
        }
        mazeTraversHelper(this.myRow, this.myColumn, mazeGrid);
        return mazeGrid[this.myDimension - 1][this.myDimension - 1];
    }

    //
    public void mazeTraversHelper(int row, int column, boolean[][] mazeGrid) {
        Room currentRoom = this.myRooms[row][column];
        mazeGrid[row][column] = true;
        if(currentRoom.isExitRoom()) { //if the player is in the exit room
            return;
        }
        // set all direction around current position
        int northRow = row - 1, northColumn = column,
                southRow = row + 1, southColumn = column,
                eastRow = row, eastColumn = column + 1,
                westRow = row, westColumn = column - 1;

        if(northRow < 0)
            northRow = this.myDimension -1;
        if(southRow >= this.myDimension)
            southRow = 0;
        if(eastColumn >= this.myDimension)
            eastColumn = 0;
        if(westColumn < 0)
            westColumn = this.myDimension -1;

        // Traversal helper
        if(!currentRoom.getMyNorthDoor().isLocked() && !mazeGrid[northRow][column]) {
            mazeTraversHelper(northRow, column, mazeGrid);
        }
        if(!currentRoom.getMySouthDoor().isLocked() && !mazeGrid[southRow][column]) {
            mazeTraversHelper(southRow, column, mazeGrid);
        }
        if(!currentRoom.getMyEastDoor().isLocked() && !mazeGrid[row][eastColumn]) {
            mazeTraversHelper(row, eastColumn, mazeGrid);
        }
        if(!currentRoom.getMyWestDoor().isLocked() && !mazeGrid[row][westColumn]) {
            mazeTraversHelper(row, westColumn, mazeGrid);
        }
    }
    /**
     *
     * @return
     */
    public String toGUI() {

        Room room = this.myRooms[this.myRow][this.myColumn];
        StringBuilder maze = new StringBuilder();
        int i, j;
        

        for (i = 0; i < this.myRooms.length; i++) {
            // build north doors
            for (j = 0; j < this.myRooms[i].length; j++) {
                maze.append("+"); // the corner of the room
                if (i == 0){
                    maze.append("W"); // build the wall
                    
                } else {
                    if(this.myRooms[i][j].getMyNorthDoor().isLocked()) {
                        maze.append("b"); // print x when the door is locked on the north
                    } else if(this.myRooms[i][j].getMyNorthDoor().isOpen()){
                    	maze.append("k");
                    }
                    else {
                        maze.append("-"); // print the door on the north
                    }
                }
            }
            maze.append("+n"); // the right corner

            // build west doors
            for (j = 0; j < this.myRooms[i].length; j++) {
                if (j == 0){
                    maze.append("V"); // build the wall
                } else {
                    if(this.myRooms[i][j].getMyWestDoor().isLocked()) {
                        maze.append("x"); // print x when the door is locked on the west
                    } else if(this.myRooms[i][j].getMyWestDoor().isOpen()){
                    	maze.append("o");
                    }
                    	else {
                        maze.append("|"); // print the west door
                    }
                }

                // in the room space
                if(this.myRooms[i][j].isExitRoom()) {
                    maze.append("e"); // Exit room at the bottom right corner
                } else if(i == this.myRow && j == this.myColumn) {
                    maze.append("P"); // Represent the player position
                } else {
                    maze.append(" "); // Empty room
                }
            }

            maze.append("E"); // print the east wall
            maze.append("n"); // go to the next line after print the last east door
        }

        // build south wall
        for (j = 0; j < this.myRooms[0].length; j++){
            maze.append("+"); // the corner of the room
            maze.append("W"); // print the door on the south
        }
        maze.append("+n"); // the corner on the bottom right of the maze
        return maze.toString();

    }

    
    public void setWalls() {
    	for (int j = 0; j < this.myRooms.length; j++) {
    		this.myRooms[0][j].setNIsWall();
    		this.myRooms[j][0].setWIsWall();
    	}
    	for (int j = 0; j < this.myRooms.length; j++) {
    		this.myRooms[this.myRooms.length-1][j].setSIsWall();
    		this.myRooms[j][this.myRooms.length-1].setEIsWall();
    	}

    }
}