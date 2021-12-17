package io;

/**
 *
 * @author Kannika Armstrong
 * The ConsoleGameData class use to update game data for save and load method
 */

import model.Maze;
import model.Room;

import java.io.Serializable;

public class ConsoleGameData implements Serializable {

    private final static long serialVersionUID = -1402116651844896243L;

    private String myGameStatus;
    private Maze myMazeGame;
    private String direction;
    private Room currentRoom;

    public ConsoleGameData(Maze myMazeGame, String direction, Room currentRoom){
        this.myMazeGame = myMazeGame;
        this.direction = direction;
        this.currentRoom = currentRoom;
    }

    public String getMyGameStatus() {
        return myGameStatus;
    }

    public void setMyGameStatus(String myGameStatus) {
        this.myGameStatus = myGameStatus;
    }

    public Maze getMyMazeGame() {
        return myMazeGame;
    }

    public void setMyMazeGame(Maze myMazeGame) {
        this.myMazeGame = myMazeGame;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
