package io;

import java.io.*;

public class ResourceManager {

    private static final String myDir = System.getProperty("user.dir");

    public static void save(Serializable data) throws Exception{
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(myDir + "/savedGame/saveConsoleGameFile.sav"))){
            oos.writeObject(data);
        }
    }

    public static Object load() throws Exception{
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(myDir + "/savedGame/saveConsoleGameFile.sav"))){
            return ois.readObject();
        }
    }
}
