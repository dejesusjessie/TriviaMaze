package io;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * @author codichun
 *
 */
public class ResourceManager {
	
	public static void saveGame(Serializable theData, String theFileName) throws Exception {
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(theFileName)))){
			oos.writeObject(theData);
		}
	}
	
	public static Object loadGame(Serializable theData, String theFileName) throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(theFileName)))){
			return ois.readObject();
		}
	}
	
}
