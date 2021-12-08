package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import model.GameRunner;
import model.MazeForGUI;
import view.IniMaze;

/**
 * The save function.
 * @author Codi Chun
 * @version Fall, 2021
 */
public class Save implements Serializable{

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -9115733040629946710L;

//	/**
//	 * The game time.
//	 */
//	private final String myGameTime;
//	
//	/**
//	 * 
//	 */
//	private final int mySystemTime;
	
	/**
	 * The string that generates the maze GUI.
	 */
	private String myGameStatus;
	
	/**
	 * The game data that needs to be saved.
	 */
	private GameData myGameData;
	
	/**
	 * The dir of the project.
	 */
	private final String myDir = System.getProperty("user.dir");
	
	/**
	 * The folder which stores the saved game.
	 */
	private final File mySaveFolder = new File(myDir + "/savedGame");
	

	/**
	 * The maze that needs to be saved.
	 */
	private MazeForGUI myMaze;
	
	/**
	 * The initial maze that needs to be saved.
	 */
	private IniMaze myIniMaze;
	
	
	/**
	 * The constructor.
	 * @param theFileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Save(String theFileName) throws FileNotFoundException, IOException {
//		this.myGameTime = InfoPanel.getGameTime();
//		this.mySystemTime = InfoPanel.getSystemTime();
		this.myGameStatus = GameRunner.getStatus();
		this.myMaze = GameRunner.getGameMaze();
		this.myIniMaze = IniMaze.getInstance();
		myGameData = new GameData(myGameStatus, myMaze, myIniMaze);
		generateFile(theFileName);

	}
	
	/**
	 * Generating the new file which needs to be saved.
	 * @param theFileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void generateFile(String theFileName) throws FileNotFoundException, IOException {
		String fileName = theFileName + ".bin";
		ObjectOutputStream saveGame = new ObjectOutputStream(new FileOutputStream(mySaveFolder.toString() + "/" + fileName));
		saveGame.writeObject(myGameData);
	}

}
