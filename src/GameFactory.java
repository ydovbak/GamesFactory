public class GameFactory {

    public Game createGame(String name) {
        if(name.equals("Uno")) {
            return new Uno("Uno", 8, true);
        }
        else if(name.equals("Checkers")) {
            return new Checkers("Checkers", false);
        }
        else if(name.equals("Chess")) {
            return new Chess("Chess", false);
        }
        else if (name.equals("Poker")) {
            return new Poker("Poker", 6, true);
        }
        else {
            // it's always good to play chess
            return new Chess("Chess, why not?", false);
        }

    }
}
