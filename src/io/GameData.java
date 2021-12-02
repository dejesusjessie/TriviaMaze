package io;

import java.io.Serializable;

import model.GameRunner;

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
	
	
	/**
	 * 
	 * @param theSystemTime
	 * @param theGameTime
	 */
	public GameData(int theSystemTime, String theGameTime, String theGameStatus, GameRunner theGameRunner) {
		this.mySystemTime = theSystemTime;
		this.myGameTime = theGameTime;
		this.myGameStatus = theGameStatus;
		this.myGameRunner = theGameRunner;
	
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
