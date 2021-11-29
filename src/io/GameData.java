package io;

import java.io.Serializable;

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
	 * @param theSystemTime
	 * @param theGameTime
	 */
	public GameData(int theSystemTime, String theGameTime, String theGameStatus) {
		this.mySystemTime = theSystemTime;
		this.myGameTime = theGameTime;
		this.myGameStatus = theGameStatus;
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

}
