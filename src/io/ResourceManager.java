package io;

/**
 *
 * @author Kannika Armstrong
 *
 */

import java.io.*;

public class ResourceManager {

    // specify the path to save and load the game (.sav data)
    private static final String myDir = System.getProperty("user.dir");

    // Use to save the game
    public static void save(Serializable data) throws Exception{
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(myDir + "/savedGame/saveConsoleGameFile.sav"))){
            oos.writeObject(data);
        }
    }

    // Use to load the Game
    public static Object load() throws Exception{
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(myDir + "/savedGame/saveConsoleGameFile.sav"))){
            return ois.readObject();
        }
    }
}
