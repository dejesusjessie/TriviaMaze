package view;

import java.io.IOException;
import java.io.Serializable;

import io.GameData;
import model.Maze;
import model.MazeBuilder;

public class IniMaze implements Serializable{
	
	private static IniMaze myInstance = null;
	
	private MazeBuilder myBuilder;
    private Maze myMaze;
    private String myMazeString;
    private transient TriviaMazeGUI myGUI;
    
	
	private IniMaze() throws IOException{
		myBuilder = new MazeBuilder();
	    myMaze = myBuilder.buildRoom();
	    myMazeString = myMaze.toGUI();
	    myGUI = new TriviaMazeGUI(myMazeString);
	}
	
//	private IniMaze(Maze theMaze, String theGameStatus) throws IOException{
//		myBuilder = new MazeBuilder();
//	    myMaze = theMaze;
//	    myMazeString = theGameStatus;
//	    myGUI = new TriviaMazeGUI(myMazeString);
//	}
	
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
		myBuilder = theGameData.getBuilder();
		myMaze = theGameData.getMaze();
		myMazeString = theGameData.getMazeString();
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
	
	public MazeBuilder getBuilder(){
		return myBuilder;
	}
	
	public Maze getMaze() {
		
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
