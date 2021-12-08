package io;

import java.io.Serializable;

import model.GameRunner;
import model.Maze;
import model.MazeBuilder;
import view.IniMaze;
import view.TriviaMazeGUI;

/**
 * 
 * @author Codi Chun
 *
 */
public class GameData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8478785890219058860L;
	
	/**
	 * 
	 */
	int mySystemTime;
	
	/**
	 * 
	 */
	String myGameTime;
	
//	/**
//	 * 
//	 */
//	String SystemTime;
	
	/**
	 * 
	 */
	String myGameStatus;
	
	/**
	 * 
	 */
	GameRunner myGameRunner;
	
	MazeBuilder myBuilder; 
	Maze myMaze;
	TriviaMazeGUI myGUI;
	IniMaze myIniMaze;
	
	
	/**
	 * 
	 * @param theSystemTime
	 * @param theGameTime
	 */
	public GameData(String theGameStatus, Maze theMaze, IniMaze theIniMaze) {
//		this.mySystemTime = theSystemTime;
		//this.myGameRunner = theGameRunner;
		//this.myBuilder = theBuilder;
		this.myMaze = theMaze;
		//this.myGUI = theGUI;
		this.myGameStatus = theGameStatus;
		this.myIniMaze = theIniMaze;
	
	}
	
	
	public IniMaze getIniMaze() {
		return myIniMaze;
	}
	
	public MazeBuilder getBuilder() {
		return myBuilder;
		
	}
	
	public Maze getMaze() {
		return myMaze;
		
	}
	
	public String getMazeString() {
		return myGameStatus;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSystemTime(){
		return mySystemTime;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getGameTime() {
		return myGameTime;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getGameStatus() {
		return myGameStatus;
		
	}
	
	/**
	 * 
	 */
	public GameRunner getGameRunner() {
		return myGameRunner;
	}

}
