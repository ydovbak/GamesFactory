import com.tus.model.Game;
import com.tus.server.Serialization;

import java.rmi.Naming;
import java.util.ArrayList;

public class GamesServer {

    public static void main(String[] args) {
        System.out.println("Server has started");
        Serialization serialization = new Serialization();

        // retrieve the games from the file
        ArrayList<Game> games = serialization.deserialize("games.ser");

        try {
            // initialise Remote implementation of array list with the games
            IArrayList gamesArrayList = new GamesArrayList();
            gamesArrayList.setGames(games);

            // bind the gamesArrayList
            Naming.rebind("gamesArrayList", gamesArrayList);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
