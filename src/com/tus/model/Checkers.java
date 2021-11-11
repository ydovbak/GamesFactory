package com.tus.model;

public class Checkers extends Game{
    public Checkers(String name, boolean isCardGame) {
        super(name, 2, isCardGame);
        super.setName("Checkers");
    }

    @Override
    public void createGame() {
        String output = "\n****************************" + uniqueName +"********************************" +
                "Setup\n" +
                "The board is positioned with the light colored square in the bottom right corner. " +
                "\nThe checkers for each player are setup on the dark colored squares. " +
                "\nPlayers should have 12 checkers in their first three rows (four in each row).\n" +
                "\n" +
                "Objective\n" +
                "The object of the game is to capture all your opponent’s checkers or " +
                "\ntrap your opponent so no move can be made." +
                "\n\n Number of players: " + numOfPlayers +
                "\n***************************************************************";
        System.out.println(output);

    }


}
