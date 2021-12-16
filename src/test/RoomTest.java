package test;

import model.Door;
import model.Maze;
import model.MazeBuilder;
import model.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testIsExitRoomMethod() {
        Room rooms = new Room();
        rooms.setExit();
        Assertions.assertTrue(rooms.isExitRoom());
    }

    @Test
    void testLockNorthMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMyNorthDoor().lock();
        // lockNorth() { this.myNorthDoor.lock(); }
        assertTrue(maze.getCurrentRoom().getMyNorthDoor().isLocked());
    }

    @Test
    void testLockSouthMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMySouthDoor().lock();
        // lockSouth() { this.mySouthDoor.lock(); }
        assertTrue(maze.getCurrentRoom().getMySouthDoor().isLocked());
    }

    @Test
    void testLockWestMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMyWestDoor().lock();
        // lockWest() { this.myWestDoor.lock(); }
        assertTrue(maze.getCurrentRoom().getMyWestDoor().isLocked());
    }

    @Test
    void testLockEastMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMyEastDoor().lock();
        // lockEast() { this.myEastDoor.lock(); }
        assertTrue(maze.getCurrentRoom().getMyEastDoor().isLocked());
    }

    @Test
    void testOpenEastMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMyEastDoor().open();
        // openEast() { this.myEastDoor.open(); }
        assertTrue(maze.getCurrentRoom().getMyEastDoor().isOpen());
    }

    @Test
    void testOpenSouthMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMySouthDoor().open();
        // openSouth() { this.mySouthDoor.open(); }
        assertTrue(maze.getCurrentRoom().getMySouthDoor().isOpen());
    }

    @Test
    void testOpenWestMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMyWestDoor().open();
        // openWest() { this.myWestDoor.open(); }
        assertTrue(maze.getCurrentRoom().getMyWestDoor().isOpen());
    }

    @Test
    void testOpenNorthMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMyNorthDoor().open();
        // openNorth() { this.myNorthDoor.open(); }
        assertTrue(maze.getCurrentRoom().getMyNorthDoor().isOpen());
    }

    @Test
    void testSetNIsWallMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().setNIsWall();
        // setNIsWall() { this.myNorthDoor.lock(); NIsWall = true; }
        assertTrue(maze.getCurrentRoom().getMyNorthDoor().isLocked());
    }

    @Test
    void testSetWIsWallMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().setWIsWall();
        // setWIsWall() { this.myWestDoor.lock(); WIsWall = true; }
        assertTrue(maze.getCurrentRoom().getMyWestDoor().isLocked());
    }

    @Test
    void testSetSIsWallMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().setSIsWall();
        // setSIsWall() { this.mySouthDoor.lock(); SIsWall = true; }
        assertTrue(maze.getCurrentRoom().getMySouthDoor().isLocked());
    }

    @Test
    void testSetEIsWallMethod() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().setEIsWall();
        // setEIsWall() { this.myEastDoor.lock(); EIsWall = true; }
        assertTrue(maze.getCurrentRoom().getMyEastDoor().isLocked());
    }
}