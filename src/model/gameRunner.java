package model;
import java.util.Scanner;
import view.TriviaMazeGUI;

/**
 * The new game runner.
 * Runs a new game. 
 * @author Codi Chun, Kannika Armstrong
 * @version Fall 2021
 */
public class gameRunner {
    MazeBuilder myBuilder;
    Maze myMaze;
    static String myMazeString;
	TriviaMazeGUI myGUI;
	
	/**
	 * Constructor.
	 * @param theBuilder
	 * @param theMaze
	 * @param theMazeString
	 * @param theGame
	 */
	public gameRunner(MazeBuilder theBuilder, Maze theMaze, String theMazeString, TriviaMazeGUI theGame){
        myBuilder = theBuilder;
        myMaze = theMaze;
        myMazeString = theMazeString;
		myGUI = theGame;
		runGame();
	}
	
	/**
	 * Running the a new game.
	 */
	public void runGame(){

        Scanner input = new Scanner(System.in);		
        while(!myMaze.reachExit()) {
            System.out.println(myMaze.toString());
            
            //maze panel repaint;
            myMazeString = myMaze.toGUI();
            myGUI.repaintMaze(myMazeString);

            
            System.out.println("Select your option: \nn --> Move North\ns --> Move South" +
                    "\nw --> Move West\ne --> Move East");

            char dir = input.next().charAt(0);
            switch(dir) {
                case('n'):
                    myMaze.moveNorth();
                    break;
                case('s'):
                    myMaze.moveSouth();
                    break;
                case('w'):
                    myMaze.moveWest();
                    break;
                case('e'):
                    myMaze.moveEast();
                	myGUI.repaint();
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }
	}
	
	
	/**
	 * Return the current status of the game.
	 */
	public static String getStatus() {
		return myMazeString;
	}

}
