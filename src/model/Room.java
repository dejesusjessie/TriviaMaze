package model;

import java.io.Serializable;

/**
 * 
 * @author Kannika Armstrong, Codi Chun
 * @version Fall 2021
 */
public class Room implements Serializable{

    // Create the doors of 4 direction
    private Door myNorthDoor;
    private Door mySouthDoor;
    private Door myEastDoor;
    private Door myWestDoor;
    private boolean exitRoom = false;


    // Getter and setter of the door on the North
    public Door getMyNorthDoor() {
        return myNorthDoor;
    }

    public void setMyNorthDoor(Door myNorthDoor) {
        this.myNorthDoor = myNorthDoor;
    }

    // Getter and setter of the door on the South
    public Door getMySouthDoor() {
        return mySouthDoor;
    }

    public void setMySouthDoor(Door mySouthDoor) {
        this.mySouthDoor = mySouthDoor;
    }

    // Getter and setter of the door on the East
    public Door getMyEastDoor() {
        return myEastDoor;
    }

    public void setMyEastDoor(Door myEastDoor) {
        this.myEastDoor = myEastDoor;
    }

    // Getter and setter of the door on the West
    public Door getMyWestDoor() {
        return myWestDoor;
    }

    public void setMyWestDoor(Door myWestDoor) {
        this.myWestDoor = myWestDoor;
    }

    // Set exit room --> Win the game if can enter to this room
    public boolean isExitRoom() {
        return this.exitRoom;
    }
    public void setExit() {
        this.exitRoom = true;
    }

    // lock the door
    public void lockNorth() {
        this.myNorthDoor.lock();
    }
    public void lockSouth() {
        this.mySouthDoor.lock();
    }
    public void lockWest() {
        this.myWestDoor.lock();
    }
    public void lockEast() {
        this.myEastDoor.lock();
    }

    
    public void openEast() {
        this.myEastDoor.open();
    }
    
    public void openSouth() {
        this.mySouthDoor.open();
    }
    
    public void openWest() {
        this.myWestDoor.open();
    }
    
    public void openNorth() {
        this.myNorthDoor.open();
    }
    
    // Set of the walls, make sure all walls are locked
    boolean NIsWall = false;
    public void setNIsWall() {
        this.myNorthDoor.lock();
        NIsWall = true;
    }
    public boolean getNIsWall() {
    	return NIsWall;
    }

    boolean WIsWall = false;
    public void setWIsWall() {
        this.myWestDoor.lock();
        WIsWall = true;
    }
    public boolean getWIsWall() {
    	return WIsWall;
    }

    boolean SIsWall = false;
    public void setSIsWall() {
    	this.mySouthDoor.lock();
        SIsWall = true;
    }
    public boolean getSIsWall() {
    	return SIsWall;
    }
    
    boolean EIsWall = false;
    public void setEIsWall() {
    	this.myEastDoor.lock();
        EIsWall = true;
    }

    public boolean getEIsWall() {
    	return EIsWall;
    }
}