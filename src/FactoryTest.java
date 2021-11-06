public class FactoryTest {


    public static void main(String[] args) {
        GameFactory factory = new GameFactory();

        Game game1 = factory.createGame("Uno");
        Game game2 = factory.createGame("Poker");

        game1.createGame();
        game2.createGame();
    }
}
