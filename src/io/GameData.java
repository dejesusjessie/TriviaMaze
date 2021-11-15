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
	
	/**
	 * 
	 */
	String theSystemTime;
	
	/**
	 * 
	 * @param theSystemTime
	 * @param theGameTime
	 */
	public GameData(int theSystemTime, String theGameTime) {
		this.mySystemTime = theSystemTime;
		this.myGameTime = theGameTime;
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

}
