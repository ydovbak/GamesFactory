import java.util.ArrayList;

public class FactoryTest {




    public static void main(String[] args) {
        GameFactory factory = new GameFactory();

//        Game game1 = factory.createGame("Uno", "Uno with classmates", 6);
//        Game game2 = factory.createGame("Uno", "Uno with classmates", 3);
//        Game game3 = factory.createGame("Poker", "Poker with freiends", 3);
//
//        game1.createGame();
//        game2.createGame();
//        game3.createGame();

        ArrayList<Game> games = new ArrayList<Game>();
//        games.add(game1);
//        games.add(game2);
//        games.add(game3);

        // serialise the phones:
        Serialization serialization = new Serialization();
        games = serialization.deserialize("games.ser");
        for (Game game : games) {
            game.createGame();
        }
    }
}
