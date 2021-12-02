package model;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.io.IOException;


import view.IniMaze;

import view.TriviaMazeGUI;

/**
 * The new game runner.
 * Runs a new game. 
 * @author Codi Chun, Kannika Armstrong
 * @version Fall 2021
 */

public class GameRunner {
	
	private static GameRunner myInstance = null;
	IniMaze myIniMaze = IniMaze.getInstance();
	
    MazeBuilder myBuilder;
    Maze myMaze;
    static String myMazeString;
	TriviaMazeGUI myGUI;
	
//	/**
//	 * Constructor.
//	 * @param theBuilder
//	 * @param theMaze
//	 * @param theMazeString
//	 * @param theGame
//	 */
//	private gameRunner(MazeBuilder theBuilder, Maze theMaze, String theMazeString, TriviaMazeGUI theGame) throws IOException{
//        myBuilder = theBuilder;
//        myMaze = theMaze;
//        myMazeString = theMazeString;
//		myGUI = theGame;
//		runGame();
//	}
	
	private GameRunner() throws IOException{
        myBuilder = myIniMaze.getBuilder();
        myMaze = myIniMaze.getMaze();
		myGUI = myIniMaze.getGUI();
		myMazeString = myIniMaze.getString();
		//runGame();

	}
	
	
	public static GameRunner getInstance() throws IOException {
		if(myInstance == null) {
			synchronized(IniMaze.class) {
				if(myInstance == null) {
					myInstance = new GameRunner();
				}
			}
		}
		
		return myInstance;
	}
	
	public void setNewGame() {
        myMazeString = myIniMaze.getString();
	}
	
	public void loadGame(String theGameStatus) {
		myMazeString = theGameStatus;
		myGUI.repaintMaze(myMazeString);
	}
	
	public TriviaMazeGUI getGUI() {
		return myGUI;
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
	 public void moveE() {
		 myMaze.moveEast();
		 update();
		 isExit();
	 }
	 
	 public void moveN() {
		 myMaze.moveNorth();
		 update();
		 isExit();
	 }
	 
	 public void moveS() {
		 myMaze.moveSouth();
		 update();
		 isExit();
	 }
	 
	 public void moveW() {
		 myMaze.moveWest();
		 update();
		 isExit();
	 }
	
	/**
	 * Return the current status of the game.
	 */
	public static String getStatus() {
		return myMazeString;
	}
	
	/**
	 * 
	 */
	public void SetMazeString(String theString) {
		myMazeString = theString;
		myGUI.repaintMaze(myMazeString);
	}

	public void update() {
		 myMazeString = myMaze.toGUI();
		 myGUI.repaintMaze(myMazeString);
	}
	
	public void isExit() {
		if(myMaze.reachExit()) {
			//JOptionPane.showOptionDialog(null, "You win!! Exit the game and ask Tom for the award!",null,JOptionPane.OK_OPTION,0,null,null,null);
			JOptionPane.showMessageDialog(null, "You win!! Exit the game and ask Tom for the award!");

		} 
	}



}
