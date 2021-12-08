package application;

import java.io.IOException;
import model.GameRunner;
import view.IniMaze;


/**
 * The main of running the program on GUI.
 * @author Codi Chun
 * @version Fall 2021
 */
public class TriviaMazeMain {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
        IniMaze myIniMaze = IniMaze.getInstance();
        GameRunner myGameRunner = GameRunner.INSTANCE;
        myGameRunner.setData(myIniMaze);

	}
}
