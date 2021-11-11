package com.tus.model;

import java.rmi.RemoteException;

public class Poker extends Game{
    public Poker(String name, int numOfPlayers, boolean isCardGame)  {
        super(name, numOfPlayers, isCardGame);
    }

    @Override
    public void createGame() {
        String output = "\n**************************" + name +"******************************" +
                "\nIn every game, a written code of model.Poker laws should be used as the " +
                "\nfinal arbiter for settling all questions. No model.Poker laws are universally " +
                "\nfollowed - there are many local customs and preferences" +
                "\n\nNumber of players: " + numOfPlayers +
                "\n*************************************************************";
        System.out.println(output);
    }
}