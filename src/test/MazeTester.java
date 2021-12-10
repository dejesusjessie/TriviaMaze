package test;

/**
 *
 * @author Kannika Armstrong
 *
 */

import model.Maze;
import model.MazeBuilder;

import java.util.Scanner;

public class MazeTester {
    public static void main(String[] args) {
        MazeTest();
    }

    private static void MazeTest() {
        Scanner input = new Scanner(System.in);
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();


        while(!maze.reachExit()) {
            System.out.println(maze.toString());
            System.out.println("Select your option: \nn --> Move North\ns --> Move South" +
                    "\nw --> Move West\ne --> Move East");

            char dir = input.next().charAt(0);
            switch(dir) {
                case('n'):
                    maze.moveNorth();
                    break;
                case('s'):
                    maze.moveSouth();
                    break;
                case('w'):
                    maze.moveWest();
                    break;
                case('e'):
                    maze.moveEast();
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }
    }
}
