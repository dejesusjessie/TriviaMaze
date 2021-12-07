package model;


import java.io.IOException;
import javax.swing.JOptionPane;
import view.IniMaze;
import view.TriviaMazeGUI;

/**
 * The new game runner.
 * Runs a new game. 
 * @author Codi Chun
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
        myMaze.setWalls();
		myGUI = myIniMaze.getGUI();
		myMazeString = myIniMaze.getString();
		

	}

	public static GameRunner getInstance() throws IOException {
		if(myInstance == null) {
			synchronized(GameRunner.class) {
				if(myInstance == null) {
					myInstance = new GameRunner();
				}
			}
		}
		return myInstance;
	}

	public void setNewGame() throws IOException {
		myInstance = null;
	}
	
	public void loadGame(String theGameStatus) {
		myMazeString = theGameStatus;
		myGUI.repaintMaze(myMazeString);
	}
	
	public TriviaMazeGUI getGUI() {
		return myGUI;
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
	 
	 public void lockE() {
		 myMaze.getCurrentRoom().lockEast();
		 update();
	 }
	 
	 public void lockS() {
		 myMaze.getCurrentRoom().lockSouth();
		 update();
	 }
	 
	 public void lockN() {
		 myMaze.getCurrentRoom().lockNorth();
		 update();
	 }
	
	 public void lockW() {
		 myMaze.getCurrentRoom().lockWest();
		 update();
	 }
	 
	 public void openE() {
		 myMaze.getCurrentRoom().openEast();;
		 update();
	 }
	 
	 public void openS() {
		 myMaze.getCurrentRoom().openSouth();;
		 update();
	 }
	 
	 public void openN() {
		 myMaze.getCurrentRoom().openNorth();;
		 update();
	 }
	 
	 public void openW() {
		 myMaze.getCurrentRoom().openWest();;
		 update();
	 }
	 
	 public Boolean EIsLock() {
		 return myMaze.getCurrentRoom().getMyEastDoor().canEnter();
	 }
	 
	 public Boolean WIsLock() {
		 return myMaze.getCurrentRoom().getMyWestDoor().canEnter();
	 }
	 
	 public Boolean NIsLock() {
		 return myMaze.getCurrentRoom().getMyNorthDoor().canEnter();
	 }
	 
	 public Boolean SIsLock() {
		 return myMaze.getCurrentRoom().getMySouthDoor().canEnter();
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
			JOptionPane.showMessageDialog(null, "You win!! Exit the game and ask Tom for the num-num!");

		} 
	}
	
	public Room getCurrentRoom() {
		return myMaze.getCurrentRoom();
		
	}

	public boolean canTraverse(){
		return myMaze.mazeTraversal();
	}

}
