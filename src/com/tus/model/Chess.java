package com.tus.model;

import java.rmi.RemoteException;

public class Chess extends Game{
    public Chess(String name, boolean isCardGame) {
        super(name, 2, isCardGame);
    }

    @Override
    public void createGame() {
        String output = "\n*************************" + name +"*****************************" +
                "\nThe board is setup as shown. There should always be a white " +
                "\nsquare at the closest right-hand side for both players. " +
                "\nRemember that the queen must be on a square that matches her color.\n" +
                "Turns:\n" +
                "\nWhite always moves first, and players alternate turns. " +
                "\nPlayers can only move one piece at a time, except when " +
                "\ncastling." +
                "\n\n Number of players: " + numOfPlayers +
                "\n*************************************************************";
        System.out.println(output);
    }
}
