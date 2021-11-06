public abstract class Game {
    protected String name;
    protected int numOfPlayers;
    protected boolean isCardGame;

    public Game(String name, int numOfPlayers, boolean isCardGame) {
        this.name = name;
        this.numOfPlayers = numOfPlayers;
        this.isCardGame = isCardGame;
    }

    /**
     * Defines some rules and number of players.
     * Outputs it to the console window
     */
    public abstract void createGame();
}
