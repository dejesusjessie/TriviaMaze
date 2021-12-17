package view;

import java.io.IOException;
import java.io.Serializable;
import io.GameData;
import model.MazeBuilderForGUI;
import model.MazeForGUI;

/**
 * The initial maze before the game. 
 * @author Codi Chun
 * @version Fall 2021
 */
public class IniMaze implements Serializable{
	
	private static IniMaze myInstance = null;
	private MazeBuilderForGUI myBuilder;
    private MazeForGUI myMaze;
    private String myMazeString;
    private transient TriviaMazeGUI myGUI;
    
	/**
	 * Constructor.
	 * @throws IOException
	 */
	private IniMaze() throws IOException{
		myBuilder = new MazeBuilderForGUI();
	    myMaze = myBuilder.buildRoom();
	    myMazeString = myMaze.toGUI();
	    myGUI = new TriviaMazeGUI(myMazeString);
	}
	
	public static IniMaze getInstance() throws IOException {
		if(myInstance == null) {
			synchronized(IniMaze.class) {
				if(myInstance == null) {
					myInstance = new IniMaze();
				}
			}
		}
		return myInstance;
	}
	
	public void setData(GameData theGameData) {
		//myBuilder = theGameData.getBuilder();
		myMaze = theGameData.getMaze();
		myMazeString = theGameData.getMazeString();
	}
	
	public void setNewMaze() {
		myBuilder = new MazeBuilderForGUI();
	    myMaze = myBuilder.buildRoom();
	    myMazeString = myMaze.toGUI();
	 
	}
	
	
	public static IniMaze getInstance(IniMaze theIniMaze) throws IOException {
		if(myInstance == null) {
			synchronized(IniMaze.class) {
				if(myInstance == null) {
					myInstance = theIniMaze;
				}
			}
		}
		
		return myInstance;
	}
	
	public static void setInstance() {
		myInstance = null;
	}
	
	public MazeBuilderForGUI getBuilder(){
		return myBuilder;
	}
	
	public MazeForGUI getMaze() {
		
		return myMaze;
		
	}
	
	public String getString() {
		return myMazeString;
		
	}
	
	public TriviaMazeGUI getGUI() {
		return myGUI;
		
	}
	
	public void setMazeString(String theMazeString) {
		myMazeString = theMazeString;
	}

}
