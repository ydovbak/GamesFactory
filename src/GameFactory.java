public class GameFactory {

    /**
     * Factory method that creates an object of the game depending on the name of the game
     * @param name name of the game
     * @return Game object that was created
     */
    public Game createGame(String name, String personalGameName, int numOfPlayers) {
        if(name.equals("Uno")) {
            return new Uno(personalGameName, numOfPlayers, true);
        }
        else if(name.equals("Checkers")) {
            return new Checkers(personalGameName, false);
        }
        else if(name.equals("Chess")) {
            return new Chess(personalGameName, false);
        }
        else if (name.equals("Poker")) {
            return new Poker(personalGameName, numOfPlayers, true);
        }
        else {
            // it's always good to play chess
            return new Chess(personalGameName, false);
        }

    }
}
