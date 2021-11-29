package view;

import java.io.IOException;

import model.Maze;
import model.MazeBuilder;

public class IniMaze {
	
	private static IniMaze myInstance = null;
	
	MazeBuilder myBuilder;
    Maze myMaze;
    String myMazeString;
    TriviaMazeGUI myGUI;
	
	private IniMaze() throws IOException{
		myBuilder = new MazeBuilder();
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

}
