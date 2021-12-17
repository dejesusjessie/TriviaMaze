package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import model.GameRunner;
import view.IniMaze;

/**
 * The Load function.
 * @author Codi Chun
 * @version Fall 2021
 */
public class Load implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1690599925663609851L;
	
	/**
	 * The name of the file which needs to be load.
	 */
	private String myFileName;
	
	/**
	 * The dir of the project.
	 */
	private final String myDir = System.getProperty("user.dir");
	
	/**
	 * The folder which stores the saved game.
	 */
	private final File myLoadFolder = new File(myDir + "/savedGame");
	
	/**
	 * The game data that loads.
	 */
	private GameData myGameData;

	/**
	 * The constructor.
	 * @param theFileName
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Load(String theFileName) throws FileNotFoundException, ClassNotFoundException, IOException, NullPointerException {
		this.myFileName = theFileName;
		readFile(theFileName);
		showLoadedGame();
	}
	
	/**
	 * Reading the file.
	 * @param theFileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void readFile(String theFileName) throws FileNotFoundException, IOException, ClassNotFoundException, NullPointerException {
		ObjectInputStream loadGameStream = new ObjectInputStream(new FileInputStream(myLoadFolder +"/" + theFileName));
		myGameData = (GameData) loadGameStream.readObject();
	}
	
	/**
	 * Show the loaded game on GUI.
	 * @throws IOException
	 */
	public void showLoadedGame() throws IOException {
		IniMaze myIniMaze = IniMaze.getInstance();
		myIniMaze.setData(myGameData);
        GameRunner.INSTANCE.setData(myIniMaze);
		myIniMaze.getGUI().repaintMaze(myGameData.getGameStatus());
		myIniMaze.getGUI().playBackgroundMusic();
	}
}
