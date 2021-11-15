package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;

import view.InfoPanel;

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

	/**
	 * The game time.
	 */
	private final String myGameTime;
	
	/**
	 * 
	 */
	private final int mySystemTime;
	
	/**
	 * 
	 */
	GameData myGameData;
	
	/**
	 * The dir of the project.
	 */
	String myDir = System.getProperty("user.dir");
	
	/**
	 * The folder which stores the saved game.
	 */
	File mySaveFolder = new File(myDir + "/savedGame");
	
	/**
	 * The constructor.
	 * @param theFileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Save(String theFileName) throws FileNotFoundException, IOException {
		this.myGameTime = InfoPanel.getGameTime();
		this.mySystemTime = InfoPanel.getSystemTime();
		myGameData = new GameData(mySystemTime, myGameTime);
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
