package com.tus.factory;

import com.tus.model.Game;
import com.tus.serialization.Serialization;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class FactoryTest {


// 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

    public static void main(String[] args) throws RemoteException {
        GameFactory factory = new GameFactory();

        Game game1 = factory.createGame("Uno", "Uno with classmates", 6);
        Game game2 = factory.createGame("Uno", "Uno with classmates", 3);
        Game game3 = factory.createGame("Poker", "Poker with friends", 3);

        game1.createGame();
        game2.createGame();
        game3.createGame();

        ArrayList<Game> games = new ArrayList<Game>();
        games.add(game1);
        games.add(game2);
        games.add(game3);

        // serialise the phones:
        Serialization serialization = new Serialization();
        serialization.serialise(games);

        games = serialization.deserialize();
        for (Game game : games) {
            System.out.println(game.createGame());
        }
    }
}
