package com.tus.model;

public class Chess extends Game{
    //private static final long serialVersionUID = -8689650379522783830L;

    public Chess(String pesonalName, boolean isCardGame) {
        super(pesonalName, 2, isCardGame);
        super.setGameType("Chess");
    }

    @Override
    public String createGame() {
        String output = "\n*************************" + personalName +"*****************************" +
                "\nThe board is setup as shown. There should always be a white " +
                "\nsquare at the closest right-hand side for both players. " +
                "\nRemember that the queen must be on a square that matches her color.\n" +
                "Turns:\n" +
                "\nWhite always moves first, and players alternate turns. " +
                "\nPlayers can only move one piece at a time, except when " +
                "\ncastling." +
                "\n\n Number of players: " + numOfPlayers +
                "\n***********************************************************************************";
        return output;
    }
}
