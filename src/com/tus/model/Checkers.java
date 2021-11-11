package com.tus.model;

public class Checkers extends Game{
    public Checkers(String personalName, boolean isCardGame) {
        super(personalName, 2, isCardGame);
        super.setGameType("Checkers");
    }

    @Override
    public String createGame() {
        String output = "\n****************************" + personalName +"********************************" +
                "Setup\n" +
                "The board is positioned with the light colored square in the bottom right corner. " +
                "\nThe checkers for each player are setup on the dark colored squares. " +
                "\nPlayers should have 12 checkers in their first three rows (four in each row).\n" +
                "\n" +
                "Objective\n" +
                "The object of the game is to capture all your opponent’s checkers or " +
                "\ntrap your opponent so no move can be made." +
                "\n\n Number of players: " + numOfPlayers +
                "\n*************************************************************************************";
        return output;
    }
}
