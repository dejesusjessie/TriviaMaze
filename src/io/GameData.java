package io;

import java.io.Serializable;
import model.GameRunner;
import model.MazeForGUI;
import view.IniMaze;
import view.TriviaMazeGUI;

/**
 * The game data that use for serialization.
 * @author Codi Chun
 * @version Fall 2021
 */
public class GameData implements Serializable{

	/**
	 * The UID number.
	 */
	private static final long serialVersionUID = -8478785890219058860L;
	
	/**
	 * Data that we might use on next version.
	 */
	private int mySystemTime;
	private String myGameTime;
	private String SystemTime;
	
	/**
	 * The game status string that generates the maze GUI.
	 */
	private String myGameStatus;
	
	/**
	 * The maze that we use for serialization. 
	 */
	private MazeForGUI myMaze;
	
	/**
	 * The initial maze that we use for serialization. 
	 */
	private IniMaze myIniMaze;
	
	
	/**
	 * The constructor.
	 * @param theSystemTime
	 * @param theGameTime
	 */
	public GameData(String theGameStatus, MazeForGUI theMaze, IniMaze theIniMaze) {
//		this.mySystemTime = theSystemTime;
		//this.myGameRunner = theGameRunner;
		//this.myBuilder = theBuilder;
		this.myMaze = theMaze;
		this.myGameStatus = theGameStatus;
		this.myIniMaze = theIniMaze;
	
	}
	
	/**
	 * The getter.
	 * @return myIniMaze
	 */
	public IniMaze getIniMaze() {
		return myIniMaze;
	}
	
	/**
	 * The getter.
	 * @return myMaze
	 */
	public MazeForGUI getMaze() {
		return myMaze;
		
	}
	
	/**
	 * The getter.
	 * @return myGameStatus
	 */
	public String getMazeString() {
		return myGameStatus;
		
	}
	
	/**
	 * The getter.
	 * @return mySystemTime
	 */
	public int getSystemTime(){
		return mySystemTime;
		
	}
	
	/**
	 * The getter.
	 * @return myGameTime
	 */
	public String getGameTime() {
		return myGameTime;
		
	}
	
	/**
	 * The getter.
	 * @return myGameStatus
	 */
	public String getGameStatus() {
		return myGameStatus;
		
	}
	

}
