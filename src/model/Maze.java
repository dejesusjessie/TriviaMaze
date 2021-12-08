package model;

import java.awt.Point;
import java.io.Serializable;

// Create the maze
public class Maze implements Serializable{

    int row; // number of rows of the maze
    int column; // number of columns of the maze
    Room[][] rooms; //create each room in the maze by using grip point
    int dimension; // dimension of each room

    //Maze constructor
    public Maze() {

        this.row = 0;
        this.column = 0;
    }

    // Getter and setter of the room
    public Room[][] getRooms() {
        return rooms;
    }
    

    public Room getCurrentRooms() {
        return this.rooms[this.row][this.column];
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }

    // Getter and setter of the dimension of the room
    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;

    }

    // toString method --> print out the maze
    @Override
    public String toString() {
        Room room = this.rooms[this.row][this.column];
        StringBuilder maze = new StringBuilder();
        int i, j;

        for (i = 0; i < this.rooms.length; i++) {
            // build north doors
            for (j = 0; j < this.rooms[i].length; j++) {
                maze.append("+"); // the corner of the room
                    if (this.rooms[i][j].getNorthDoor().isLocked()) {
                        maze.append("x"); // print x when the door is locked on the north
                    } else if (this.rooms[i][j].getNorthDoor().isOpen()) {
                        maze.append(" ");
                    } else{
                        maze.append("-"); // print the door on the north
                    }
            }
            maze.append("+\n"); // the right corner

            // build west doors
            for (j = 0; j < this.rooms[i].length; j++) {
                    if(this.rooms[i][j].getWestDoor().isLocked()) {
                        maze.append("x"); // print x when the door is locked on the west
                    } else if (this.rooms[i][j].getWestDoor().isOpen()){
                        maze.append(" ");
                    } else {
                        maze.append("|"); // print the west door
                    }

                // in the room space
                if(this.rooms[i][j].isExitRoom()) {
                    maze.append("E"); // Exit room at the bottom right corner
                } else if(i == this.row && j == this.column) {
                    maze.append("P"); // Represent the player position
                } else {
                    maze.append(" "); // Empty room
                }
            }
            if(this.rooms[i][j-1].getEastDoor().isLocked()) {
                maze.append("x");
            } else if (this.rooms[i][j-1].getEastDoor().isOpen()) {
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
            if(this.rooms[this.rooms.length-1][j].getSouthDoor().isLocked()) {
                maze.append("x");
            } else if (this.rooms[this.rooms.length-1][j].getSouthDoor().isOpen()) {
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
        Room currentRoom = this.rooms[this.row][this.column];
        if(currentRoom.getNorthDoor().canEnter()) { // If canEnter to the north room
            this.row--;

            if(this.row <= 0) {
                this.row = 0; // make sure that the player cannot move through the wall

//            if(this.row < 0) {
//                this.row = this.rooms.length - 1;
                //this.row = 0; // make sure that the player cannot move through the wall

                //System.out.println("This is the wall! Please try the other way.");
            }
            //currentRoom.getNorthDoor().lock();
        } else {
            //System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the south
    public void moveSouth() {
        Room currentRoom = this.rooms[this.row][this.column];
        if(currentRoom.getSouthDoor().canEnter()) { // If canEnter to the south room
            this.row++;
            if (this.row >= this.rooms.length) {

                this.row = this.rooms.length - 1; // make sure that the player cannot move through the wall
               // System.out.println("This is the wall! Please try the other way.");
//=======
//                this.row = 0;
//                //this.row = this.rooms.length - 1; // make sure that the player cannot move through the wall
//                //System.out.println("This is the wall! Please try the other way.");
//>>>>>>> a399629c79fecac35e9d70c373ae106703ca20f3
            }
            //currentRoom.getSouthDoor().lock();
        } else {
            System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the east
    public void moveEast() {
        Room currentRoom = this.rooms[this.row][this.column];
        if(currentRoom.getEastDoor().canEnter()) { // If canEnter to the east room
            this.column++;
            if(this.column >= this.rooms.length) {
//<<<<<<< HEAD
                this.column = this.rooms.length - 1; // make sure that the player cannot move through the wall
//=======
//                this.column = 0;
//                //this.column = this.rooms.length - 1; // make sure that the player cannot move through the wall
//>>>>>>> a399629c79fecac35e9d70c373ae106703ca20f3
                //System.out.println("This is the wall! Please try the other way.");
            }
            //currentRoom.getEastDoor().lock();
        } else {
            //System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the west
    public void moveWest() {
        Room curRoom = this.rooms[this.row][this.column];
        if(curRoom.getWestDoor().canEnter()) { // If canEnter to the west room
            this.column--;
            if (this.column <= 0) {
//<<<<<<< HEAD
                this.column = 0; // make sure that the player cannot move through the wall
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
        return this.rooms[this.row][this.column].isExitRoom();
    }

    // Get the position
    public Point getPosition() {
        return new Point(this.row, this.row);
    }

    // Get the current room position
    public Room getCurrentRoom() {
        return this.rooms[this.row][this.column];
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
        mazeTraversHelper(this.row, this.column, mazeGrid);
        return mazeGrid[this.dimension - 1][this.dimension - 1];
    }

    //
    public void mazeTraversHelper(int row, int column, boolean[][] mazeGrid) {
        Room currentRoom = this.rooms[row][column];
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
            northRow = this.dimension -1;
        if(southRow >= this.dimension)
            southRow = 0;
        if(eastColumn >= this.dimension)
            eastColumn = 0;
        if(westColumn < 0)
            westColumn = this.dimension -1;

        // Traversal helper
        if(!currentRoom.getNorthDoor().isLocked() && !mazeGrid[northRow][column]) {
            mazeTraversHelper(northRow, column, mazeGrid);
        }
        if(!currentRoom.getSouthDoor().isLocked() && !mazeGrid[southRow][column]) {
            mazeTraversHelper(southRow, column, mazeGrid);
        }
        if(!currentRoom.getEastDoor().isLocked() && !mazeGrid[row][eastColumn]) {
            mazeTraversHelper(row, eastColumn, mazeGrid);
        }
        if(!currentRoom.getWestDoor().isLocked() && !mazeGrid[row][westColumn]) {
            mazeTraversHelper(row, westColumn, mazeGrid);
        }
    }
    /**
     *
     * @return
     */
    public String toGUI() {

        Room room = this.rooms[this.row][this.column];
        StringBuilder maze = new StringBuilder();
        int i, j;
        

        for (i = 0; i < this.rooms.length; i++) {
            // build north doors
            for (j = 0; j < this.rooms[i].length; j++) {
                maze.append("+"); // the corner of the room
                if (i == 0){
                    maze.append("W"); // build the wall
                    
                } else {
                    if(this.rooms[i][j].getNorthDoor().isLocked()) {
                        maze.append("b"); // print x when the door is locked on the north
                    } else if(this.rooms[i][j].getNorthDoor().isOpen()){
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
                    if(this.rooms[i][j].getWestDoor().isLocked()) {
                        maze.append("x"); // print x when the door is locked on the west
                    } else if(this.rooms[i][j].getWestDoor().isOpen()){
                    	maze.append("o");
                    }
                    	else {
                        maze.append("|"); // print the west door
                    }
                }

                // in the room space
                if(this.rooms[i][j].isExitRoom()) {
                    maze.append("e"); // Exit room at the bottom right corner
                } else if(i == this.row && j == this.column) {
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