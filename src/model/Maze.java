package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Arrays;

/**
 * The Maze class
 * @author Kannika Armstrong
 * @version Fall 2021
 */

public class Maze implements Serializable {

    private int myPlayerRow; // current row of the maze
    private int myPlayerColumn; // current column of the maze
    private Room[][] myRooms; // create each room in the maze by using grid point
    private int myDimension; // dimension of the maze

    // Maze constructor
    public Maze() {
        this.myPlayerRow = 0;
        this.myPlayerColumn = 0;
    }

    public Maze(int dimension){
        this.myDimension = dimension;
    }

    // Getter and setter of the room
    public Room[][] getMyRooms() {
        return myRooms;
    }

    public void setMyRooms(Room[][] theRooms) {
        this.myRooms = theRooms;
    }

    // Getter and setter of the dimension of the maze
    public int getMyDimension() {
        return myDimension;
    }

    public void setMyDimension(int theDimension) {
        this.myDimension = theDimension;
    }

    // toString method --> print out the maze
    @Override
    public String toString() {
        Room room = this.myRooms[this.myPlayerRow][this.myPlayerColumn];
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
                } else if(i == this.myPlayerRow && j == this.myPlayerColumn) {
                    maze.append("P"); // Represent the player position
                } else {
                    maze.append(" "); // Empty room
                }
            }
            if(this.myRooms[i][j-1].getMyEastDoor().isLocked()) {
                maze.append("x"); // print x when the door is locked on the west
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
                maze.append("x"); // print x when the door is locked on the west
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
        Room currentRoom = this.myRooms[this.myPlayerRow][this.myPlayerColumn];
        if(currentRoom.getMyNorthDoor().canEnter()) { // If canEnter to the north room
            this.myPlayerRow--;
            if(this.myPlayerRow <= 0) {
                this.myPlayerRow = this.myRooms.length - 1;
            }
        } else {
            System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the south
    public void moveSouth() {
        Room currentRoom = this.myRooms[this.myPlayerRow][this.myPlayerColumn];
        if(currentRoom.getMySouthDoor().canEnter()) { // If canEnter to the south room
            this.myPlayerRow++;
            if (this.myPlayerRow >= this.myRooms.length) {
                this.myPlayerRow = 0;
            }
        } else {
            System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the east
    public void moveEast() {
        Room currentRoom = this.myRooms[this.myPlayerRow][this.myPlayerColumn];
        if(currentRoom.getMyEastDoor().canEnter()) { // If canEnter to the east room
            this.myPlayerColumn++;
            if(this.myPlayerColumn >= this.myRooms.length) {
                this.myPlayerColumn = 0;
            };
        } else {
            System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // moving to the west
    public void moveWest() {
        Room curRoom = this.myRooms[this.myPlayerRow][this.myPlayerColumn];
        if(curRoom.getMyWestDoor().canEnter()) { // If canEnter to the west room
            this.myPlayerColumn--;
            if (this.myPlayerColumn <= 0) {
                this.myPlayerColumn = this.myRooms.length - 1;
            }
        }else {
            System.out.println("Door is Locked.\n"); // Cannot enter if the door is locked
        }
    }

    // When the player can reach the exit room --> exit the game
    public boolean reachExit() {
        return this.myRooms[this.myPlayerRow][this.myPlayerColumn].isExitRoom();
    }

    // Get the position
    public Point getPosition() {
        return new Point(this.myPlayerRow, this.myPlayerColumn);
    }

    // Get the current room position
    public Room getCurrentRoom() {
        return this.myRooms[this.myPlayerRow][this.myPlayerColumn];
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
        mazeTraversHelper(this.myPlayerRow, this.myPlayerColumn, mazeGrid);
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
}