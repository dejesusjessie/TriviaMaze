package test;

import model.Maze;
import model.MazeBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MazeTest {

    @Test
    void testGetDimensionDefaultDimension() {
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        // test default maze direction 4
        Assertions.assertEquals(4, maze.getMyDimension());
    }

    @Test
    void testGetDimensionCustomDimension() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        Assertions.assertEquals(6, maze.getMyDimension());
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
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.moveNorth();
        Assertions.assertEquals(5, maze.getPosition().getX());
        Assertions.assertEquals(0, maze.getPosition().getY());
    }

    @Test
    void testMoveSouthMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.moveSouth();
        Assertions.assertEquals(1, maze.getPosition().getX());
        Assertions.assertEquals(0, maze.getPosition().getY());
    }

    @Test
    void testMoveEastMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.moveEast();
        Assertions.assertEquals(0, maze.getPosition().getX());
        Assertions.assertEquals(1, maze.getPosition().getY());
    }

    @Test
    void testMoveWestMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.moveWest();
        Assertions.assertEquals(0, maze.getPosition().getX());
        Assertions.assertEquals(5, maze.getPosition().getY());
    }

    @Test
    void testReachExitMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        maze.moveWest();
        maze.moveNorth();
        Assertions.assertTrue(maze.reachExit());
    }

    @Test
    void testGetPositionMethod() {
        MazeBuilder builder = new MazeBuilder(6);
        Maze maze = builder.buildRoom();
        Assertions.assertEquals(0, maze.getPosition().getX());
        Assertions.assertEquals(0, maze.getPosition().getY());
    }
}