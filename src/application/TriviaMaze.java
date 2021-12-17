package application;

import java.io.IOException;
import model.GameRunner;
import view.IniMaze;
import view.PromptPanel;


/**
 * The main of running the program on GUI.
 * @author Codi Chun, Kannika Armstrong
 * @version Fall 2021
 */
public class TriviaMaze {

	public static void main(String[] args) throws ClassNotFoundException, IOException, NullPointerException {
//        IniMaze myIniMaze = IniMaze.getInstance();
//        GameRunner myGameRunner = GameRunner.INSTANCE;
//        myGameRunner.setData(myIniMaze);
        new PromptPanel();
	}
}
