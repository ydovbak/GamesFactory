public abstract class Game {
    protected String name;
    protected int numOfPlayers;
    protected boolean isCardGame;

    public Game(String name, int numOfPlayers, boolean isCardGame) {
        this.name = name;
        this.numOfPlayers = numOfPlayers;
        this.isCardGame = isCardGame;
    }


    public abstract void createGame();
}
