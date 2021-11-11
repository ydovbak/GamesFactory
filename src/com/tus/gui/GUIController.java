package com.tus.gui;

import com.tus.model.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class GUIController implements ActionListener, WindowListener {


    private GUIView view;
    private ArrayList<Game> games;

    public GUIController(ArrayList<Game> games)
    {
        // set the games
        this.games = games;

        view = new GUIView(games.size());
        view.init();

        // set the action listeners for all the buttons
        view.setWindowsListener(this);
        view.getAddGame().addActionListener(this);
        view.getRemoveGame().addActionListener(this);
        view.getViewGame().addActionListener(this);
        view.getEditGame().addActionListener(this);
        view.getPlayGameBtn().addActionListener(this);
        view.getPrintAllBtn().addActionListener(this);
    }


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

    private void addGame() {
        // basic check for empty fields
//        if (view.getfNameFieldStudent().getText().isEmpty()
//                || view.getlNameFieldStudent().getText().isEmpty()
//                || view.getAddressFieldStudent().getText().isEmpty()
//                || view.getPhoneFieldStudent().getText().isEmpty()
//                || view.getStudentNumFieldStudent().getText().isEmpty()
//                || view.getGenderFieldStudent().getText().isEmpty())
//        {
//            view.setStudentWarning("Error: Cannot add new student with empty fields.");
//        }
//        else
//        {
//            // getting and converting gender
//            char gender = view.getGenderFieldStudent().getText().charAt(0);
//            personModels.add(new StudentModel(view.getfNameFieldStudent().getText(), view.getlNameFieldStudent().getText(), view.getAddressFieldStudent().getText(), view.getPhoneFieldStudent().getText(), gender, view.getGenderFieldStudent().getText()));
//            view.setStudentWarning("Success: New student added successfully");
//        }

    }

    private void viewGame() {
        // get the id that is selected
        int selecteId = view.getGameIdsComboBox().getSelectedIndex();

        // get the game
        Game selectedGame = games.get(selecteId);

        // init the fields with the respective data
        view.setGameTypesComboBox(selectedGame.getName());
        System.out.println("unique name: " + selectedGame.getUniqueName());
        view.getUniqueNameField().setText(selectedGame.getUniqueName());
        view.getNumOfPlayersField().setText(selectedGame.getNumOfPlayers()+"");
    }

    private void removeGame() {

        // searching for the index of element with the same first name
//        int index = -1;
//        for (int i = 0; i < personModels.size(); i++)
//        {
//            if (personModels.get(i).getFirstName().equals(view.getfNameFieldStudent().getText())){
//                index = i;
//                break;
//            }
//        }
//
//        // if element was found, remove
//        if(index != -1){
//            personModels.remove(index);
//            view.setStudentWarning("Success: Element was removed");
//        }
//        else
//        {
//            view.setStudentWarning("Element not found");
//        }
    }

    private void editGame() {

        // searching for the index of element with the same first name
//        int index = -1;
//        for (int i = 0; i < personModels.size(); i++)
//        {
//            if (personModels.get(i).getFirstName().equals(view.getfNameFieldLecturer().getText())){
//                index = i;
//                break;
//            }
//        }
//
//        // if element was found, remove
//        if(index != -1){
//            personModels.remove(index);
//            view.setLecturerWarning("Success: Element was removed");
//        }
//        else
//        {
//            view.setLecturerWarning("Element not found");
//        }
    }

    private void printAllGames() {
        String text = "";

        // if list of games is not empty
        if(games.size() > 0) {
            for (int i = 0; i < games.size(); i++)
            {
                text = "ID: " + i  + games.get(i) + "\n";
            }

            view.getPrintArea().setText(text);
            view.setWarning("Success: All games printed");
        }
        else {
            view.setWarning("No games in the DB yet. Create one!");
        }


    }

    public void playGame() {

    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("window started");
    }

    @Override
    public void windowClosing(WindowEvent e) {
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
