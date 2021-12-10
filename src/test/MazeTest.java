package test;

import model.Maze;
import model.MazeBuilder;
import model.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void testGetDimensionDefaultDimension() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        // test default maze direction 4
        Assertions.assertEquals(4, maze.getDimension());
    }

    @Test
    void testGetDimensionCustomDimension() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        Assertions.assertEquals(6, maze.getDimension());
    }

    @Test
    void testMazeToString() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        Assertions.assertEquals(
                "+-+-+-+-+\n" +
                "|P| | | |\n" +
                "+-+-+-+-+\n" +
                "| | | | |\n" +
                "+-+-+-+-+\n" +
                "| | | | |\n" +
                "+-+-+-+-+\n" +
                "| | | |E|\n" +
                "+-+-+-+-+\n", maze.toString());
    }

    @Test
    void testMoveNorthMethod() {

    }

    @Test
    void moveSouth() {
    }

    @Test
    void moveEast() {
    }

    @Test
    void moveWest() {
    }

    @Test
    void reachExit() {

    }

    @Test
    void getPosition() {
    }

    @Test
    void getCurrentRoom() {
    }

    @Test
    void mazeTraversal() {
    }

    @Test
    void mazeTraversHelper() {
    }

    @Test
    void toGUI() {
    }

    @Test
    void setWalls() {
    }
}