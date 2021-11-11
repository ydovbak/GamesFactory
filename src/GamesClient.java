import com.tus.gui.GUIController;
import com.tus.model.Game;

import java.rmi.Naming;
import java.util.ArrayList;

public class GamesClient {
    public static void main(String[] args) {
        // Locally stored rmi
        String url = "rmi:///";
        System.out.println("Client has started");

        try {
            // get the list of games from the server
            IArrayList gamesArrayList = (IArrayList) Naming.lookup(url + "gamesArrayList");
            ArrayList<Game> games = gamesArrayList.getGames();
            for (Game game : games) {
                game.createGame();
            }

            // run the GUI
            GUIController gui = new GUIController(games);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
