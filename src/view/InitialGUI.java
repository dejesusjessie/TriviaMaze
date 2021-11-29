package view;

import java.io.IOException;

import model.Maze;
import model.MazeBuilder;

public class InitialGUI {
	MazeBuilder myBuilder = new MazeBuilder();
    Maze myMaze = myBuilder.buildRoom();
    String myMazeString = myMaze.toGUI();
    TriviaMazeGUI myGUI = new TriviaMazeGUI(myMazeString);
	
	public InitialGUI() throws IOException{
		
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
