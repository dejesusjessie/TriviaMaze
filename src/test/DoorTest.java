package test;

import model.Maze;
import model.MazeBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoorTest {

    @Test
    void testIsLockedMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMySouthDoor().lock();
        Assertions.assertTrue(maze.getCurrentRoom().getMySouthDoor().isLocked());
    }

    @Test
    void testIsOpenMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMySouthDoor().open();
        Assertions.assertTrue(maze.getCurrentRoom().getMySouthDoor().isOpen());
    }

    @Test
    void testLockMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMySouthDoor().setLocked(true);
        // lock() { this.locked = true; }
        assertTrue(maze.getCurrentRoom().getMySouthDoor().isLocked());
    }

    @Test
    void testUnlockMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMySouthDoor().setLocked(false);
        // unlock() { this.locked = false; }
        assertFalse(maze.getCurrentRoom().getMySouthDoor().isLocked());
    }

    @Test
    void testOpenMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMySouthDoor().setOpen(true);
        // open() { this.open = true; }
        assertTrue(maze.getCurrentRoom().getMySouthDoor().isOpen());
    }

    @Test
    void testCloseMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMySouthDoor().setOpen(false);
        // close() { this.open = false; }
        assertFalse(maze.getCurrentRoom().getMySouthDoor().isOpen());
    }

    @Test
    void canEnter() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.getCurrentRoom().getMySouthDoor().setOpen(true);
        // canEnter() { this.open = true; }
        assertTrue(maze.getCurrentRoom().getMySouthDoor().canEnter());
    }
}