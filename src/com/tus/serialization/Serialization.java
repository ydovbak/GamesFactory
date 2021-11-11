package com.tus.serialization;

import com.tus.model.Game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Class implements the serialization and deserialization
 * of games ArrayList
 */
public class Serialization {

    private final String fileName = "games.ser";

    /**
     * Method serializes a list of games to "games.ser"
     */
    public void serialise(ArrayList<Game> games) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fout);
            outputStream.writeObject(games);
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method deserializes all games from the file
     * @return an ArrayList of games that were stored in the file
     */
    public ArrayList<Game> deserialize() {
        ArrayList<Game> games = new ArrayList<>();
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fin);
            games  = (ArrayList<Game>) objectInputStream.readObject();
            objectInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }

}
