package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import view.InfoPanel;
import view.TriviaMazeGUI;

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
	String myFileName;
	
	/**
	 * The dir of the project.
	 */
	String myDir = System.getProperty("user.dir");
	
	/**
	 * The folder which stores the saved game.
	 */
	File myLoadFolder = new File(myDir + "/savedGame");

	/**
	 * The constructor.
	 * @param theFileName
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Load(String theFileName) throws FileNotFoundException, ClassNotFoundException, IOException {
		this.myFileName = theFileName;
		readFile(theFileName);
	}
	
	/**
	 * Reading the file.
	 * @param theFileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void readFile(String theFileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream loadGameStream = new ObjectInputStream(new FileInputStream(myLoadFolder +"/" + theFileName));
//		Object loadGame = loadGameStream.readObject();
//		System.out.println(loadGame);
		GameData myGameData = (GameData) loadGameStream.readObject();
		TriviaMazeGUI.reloadGUI(myGameData);
		
		
		
		System.out.println(myGameData.myGameTime);
		
	}
	
}
