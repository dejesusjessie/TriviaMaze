package model;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import view.IniMaze;
import view.TriviaMazeGUI;

/**
 * The new game runner.
 * Runs a new game.
 * Singleton pattern.
 * @author Codi Chun
 * @version Fall 2021
 */

public enum GameRunner {
	
	INSTANCE;
	
    public static MazeBuilderForGUI myBuilder;
    public static MazeForGUI myMaze;
    public static String myMazeString;
	public static TriviaMazeGUI myGUI;
	
	
	public void setData(IniMaze theIniMaze) {
        myBuilder = theIniMaze.getBuilder();
        myMaze = theIniMaze.getMaze();
        myMaze.setWalls();
        myGUI = theIniMaze.getGUI();
        myMazeString = theIniMaze.getString();
	}
	
	public void setNewGame() throws IOException, NullPointerException {
		IniMaze myIniMaze = IniMaze.getInstance();
		myIniMaze.setNewMaze();
        GameRunner.INSTANCE.setData(myIniMaze);
		myIniMaze.getGUI().repaintMaze(myIniMaze.getString());
		myIniMaze.getGUI().playBackgroundMusic();
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
	
	public static MazeBuilderForGUI getGameMazeBuilder() {
		return myBuilder;
	}
	
	public static MazeForGUI getGameMaze() {
		return myMaze;
	}
	
	public static TriviaMazeGUI getGameGUI() {
		return myGUI;
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
			myGUI.getRoomPanel().stopBackgroundMusic();
			myGUI.getRoomPanel().playWinSound();
			//JOptionPane.showMessageDialog(null, "You win!! Exit the game and ask Tom for the num-num!");
			ImageIcon huskyClapImg = new ImageIcon("src/image/huskyClap.gif");
			
			Object[] options = {"Restart", "Exit"};
			int response = JOptionPane.showOptionDialog(null,
					"You win!! Exit the game and ask Tom for the num-num!",
					"Congrats!",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					huskyClapImg,
					options,  //the titles of buttons
					options[0]); //default button title
			if (response == JOptionPane.YES_OPTION){
				try {
					GameRunner.INSTANCE.setNewGame();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (response == JOptionPane.NO_OPTION){
				System.exit(0);
			}
		} 
		

	}
	
	public Room getCurrentRoom() {
		return myMaze.getCurrentRoom();
		
	}


	public boolean canTraverse(){
		return myMaze.mazeTraversal();
	}
	




}