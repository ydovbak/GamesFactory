public class Uno extends Game {

    public Uno(String name, int numOfPlayers, boolean isCardGame) {
        super(name, numOfPlayers, isCardGame);
    }

    @Override
    public void createGame() {
        String output = "\n*****************************" + name +"*********************************" +
                "\nPlayer with the highest point value is the dealer. " +
                "\nShuffle the deck. Each player is dealt 7 cards.\n" +
                "\nPlace the remaining cards facedown to form a draw pile. " +
                "\nTurn over the top card of the draw pile to begin a discard pile. " +
                "\n- If the top card is a Wild or Wild Draw 4, return it to the deck " +
                "\nand pick another card. " +
                "\n- For all other cards, see directions for those cards. \n" +
                "\nPlayers in game: " + numOfPlayers +
                "\n*****************************************************************";
        System.out.println(output);
    }
}
