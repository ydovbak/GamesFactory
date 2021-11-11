package com.tus.model;

public class Poker extends Game{
    public Poker(String personalName, int numOfPlayers, boolean isCardGame)  {
        super(personalName, numOfPlayers, isCardGame);
        super.setGameType("Poker");
    }

    @Override
    public String createGame() {
        String output = "\n**************************" + personalName +"******************************" +
                "\nIn every game, a written code of model.Poker laws should be used as the " +
                "\nfinal arbiter for settling all questions. No model.Poker laws are universally " +
                "\nfollowed - there are many local customs and preferences" +
                "\n\nNumber of players: " + numOfPlayers +
                "\n**********************************************************************************";
        return output;
    }
}
