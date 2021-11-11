package com.tus.server;

import com.tus.model.Game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization {

    /**
     * Method serializes a list of games to "games.ser"
     */
    public void serialise(ArrayList<Game> games) {
        try {
            FileOutputStream fout = new FileOutputStream("games.ser");
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
    public ArrayList<Game> deserialize(String file) {
        ArrayList<Game> games = new ArrayList<>();
        try {
            FileInputStream fin = new FileInputStream(file);
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
