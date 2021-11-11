package com.tus.gui;

import com.tus.model.Game;
import com.tus.serialization.Serialization;
import com.tus.factory.GameFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/// Is it ok that serialization happens in the GUI control and not in the client?
/// is it ok that serialisation happens not on the server
public class GUIController implements ActionListener, WindowListener {

    private GUIView view;
    private ArrayList<Game> games;
    private GameFactory factory;
    private Serialization serialization;

    public GUIController(ArrayList<Game> games)
    {
        // set the games
        this.games = games;

        // init the GUI
        view = new GUIView(games.size());
        view.init();

        // init the factory and serialization
        factory = new GameFactory();
        serialization = new Serialization();

        // set the action listeners for all the buttons
        view.setWindowsListener(this);
        view.getAddGame().addActionListener(this);
        view.getRemoveGame().addActionListener(this);
        view.getViewGame().addActionListener(this);
        view.getEditGame().addActionListener(this);
        view.getPlayGameBtn().addActionListener(this);
        view.getPrintAllBtn().addActionListener(this);
    }

    /**
     * Map the action performed by user to the method invoked in this class.
     * @param e ActionEvent that is caused by user interaction with the window.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // reset warning msg
        view.setWarning("");

        // mapping methods to actions
        if (e.getSource() == view.getAddGame())
        {
            addGame();
        }else if (e.getSource() == view.getViewGame())
        {
            viewGame();
        }else if (e.getSource() == view.getRemoveGame())
        {
            removeGame();
        }
        else if (e.getSource() == view.getEditGame())
        {
            editGame();
        }
        else if (e.getSource() == view.getPrintAllBtn())
        {
            printAllGames();
        }
        else if (e.getSource() == view.getPlayGameBtn())
        {
            playGame();
        }
    }

    /**
     * Method adds a new game to the ArrayList of games.
     */
    private void addGame() {
        // reset printout field
        view.getPrintArea().setText("");

        // basic check for empty fields
        if (view.getUniqueNameField().getText().isEmpty()
                || view.getNumOfPlayersField().getText().isEmpty())
        {
            view.setWarning("Error: Cannot add new game with empty fields.");
        }
        else
        {
            // get the game type
            String gameType = (String) view.getGameTypesComboBox().getSelectedItem();

            // get unique name and number of players
            String uniqueName = view.getUniqueNameField().getText();
            int numOfPlayers = Integer.parseInt( view.getNumOfPlayersField().getText());

            Game newGame =  factory.createGame(gameType, uniqueName, numOfPlayers);
            games.add(newGame);
            view.setWarning("Success: New game added successfully");

            // set the combo box item
            int numOfGames = games.size();
            view.initIdComboComboBox(numOfGames);
            view.getGameIdsComboBox().setSelectedIndex(numOfGames-1);
        }
    }

    /**
     * Method displays the info about the game, ID if which was selected on the window.
     */
    private void viewGame() {
        // reset printout field
        view.getPrintArea().setText("");

        // empty the warning message
        view.setWarning("");

        // get the id that is selected
        int selectedId = view.getGameIdsComboBox().getSelectedIndex();

        // get the game
        Game selectedGame = games.get(selectedId);
        // init the fields with the respective data
        view.setGameTypesComboBox(selectedGame.getGameType());
        System.out.println("unique name: " + selectedGame.getPersonalName());
        view.getUniqueNameField().setText(selectedGame.getPersonalName());
        view.getNumOfPlayersField().setText(selectedGame.getNumOfPlayers()+"");

        // set the combo box item
        view.getGameIdsComboBox().setSelectedIndex(selectedId);
    }

    /**
     * Method removes the game from the ArrayList, ID if which was selected on the window.
     */
    private void removeGame() {
        // reset printout field
        view.getPrintArea().setText("");

        // get the id that is selected
        int selecteId = view.getGameIdsComboBox().getSelectedIndex();

        // remove it from the ArrayList
        Game g = games.remove(selecteId);
        System.out.println("Game removed: " + g);

        // set the combo box item
        view.getGameIdsComboBox().setSelectedIndex(0);

        // display the 0-th game
        viewGame();

        // Inform the user in the warning message
        view.setWarning("Game \"" + g.getPersonalName() + "\" was removed");
    }

    /**
     * Method fetches the information entered by the user and updates the data of the game,
     * Id of which was selected on the window.
     */
    private void editGame() {
        // reset printout field
        view.getPrintArea().setText("");

        // get the id that is selected
        int selecteId = view.getGameIdsComboBox().getSelectedIndex();

        // basic check for empty fields
        if (view.getUniqueNameField().getText().isEmpty()
                || view.getNumOfPlayersField().getText().isEmpty())
        {
            view.setWarning("Error: Cannot edit the game with empty fields.");
        }
        else
        {
            // get unique name and number of players
            String uniqueName = view.getUniqueNameField().getText();
            int numOfPlayers = Integer.parseInt( view.getNumOfPlayersField().getText());

            // change the game data
            games.get(selecteId).setPersonalName(uniqueName);
            games.get(selecteId).setNumOfPlayers(numOfPlayers);
            view.setWarning("Success: Game was edited successfully");
        }
    }

    /**
     * Method prints the information about all the games that were created.
     */
    private void printAllGames() {
        String text = "";

        // if list of games is not empty
        if(games.size() > 0) {
            for (int i = 0; i < games.size(); i++)
            {
                text += "ID: " + i  + games.get(i) + "\n";
            }

            view.getPrintArea().setText(text);
            view.setWarning("Success: All games printed");
        }
        else {
            view.setWarning("No games in the DB yet. Create one!");
        }


    }

    /**
     * Method calls the createGame() on the game that was selected by the user.
     */
    public void playGame() {

        // get the id that is selected
        int selecteId = view.getGameIdsComboBox().getSelectedIndex();

        if (games.size() > 0) {
            Game selectedGame = games.get(selecteId);
            String text = selectedGame.createGame();
            view.getPrintArea().setText(text);
            view.setWarning("Success: All games printed");
        }
        else {
            view.setWarning("No games in the DB yet. Create one!");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("window started");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // serialise the games back to the file
        serialization.serialise(games);

        System.out.println("Games were serialised");

        // stop the program
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
