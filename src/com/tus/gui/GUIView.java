package com.tus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;

public class GUIView extends JFrame {
    // font for the GUI
    Font  f1  = new Font(Font.SERIF, Font.PLAIN,  16);

    // Lecturers button and labels
    private JButton addGame = new JButton("Add Game");
    private JButton removeGame = new JButton("Remove Game");
    private JButton editGame = new JButton("Edit Game");
    private JButton viewGame = new JButton("View Game");
    private JButton playGameBtn = new JButton("Play");

    private JLabel gameIdLab = new JLabel("Game ID (Edit/Remove/View)");
    private JLabel chooseGameLab = new JLabel("Chose the game:");
    private JLabel uniqueNameLab = new JLabel("Unique Name:");
    private JLabel numOfPlayersLab = new JLabel("Number of players:");
    private JLabel warning = new JLabel("***Add Warning***: ");

    private String[] gameTypes = { "Uno", "Checkers", "Chess", "Poker" };
    private JComboBox gameTypesComboBox = new JComboBox(gameTypes);
    private JComboBox gameIdsComboBox = new JComboBox();

    //private JTextField gameIdField = new JTextField();
    private JTextField uniqueNameField = new JTextField();
    private JTextField numOfPlayersField = new JTextField();

    // print area
    private JButton printAllBtn = new JButton("Print All");
    private JLabel printLab = new JLabel("Print Area:");
    private JTextArea printArea = new JTextArea();

    // panels
    private JPanel menuPanel = new JPanel();
    private JPanel comboBoxPanel = new JPanel();
    private JPanel idComboBoxPanel = new JPanel();
    private JPanel panelGame = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JPanel printPanel = new JPanel();

    // container for everything
    private Container contentPane = this.getContentPane();

    private int IDs;


    public GUIView(int numOfIds)
    {
        this.IDs = numOfIds;
        this.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        this.setSize(1000,650);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }


    public void init()
    {
        // set the fonts
        addGame.setFont(f1);
        removeGame.setFont(f1);
        editGame.setFont(f1);
        viewGame.setFont(f1);
        playGameBtn.setFont(f1);
        gameIdLab.setFont(f1);
        chooseGameLab.setFont(f1);
        uniqueNameLab.setFont(f1);
        numOfPlayersLab.setFont(f1);
        warning.setFont(f1);
        gameTypesComboBox.setFont(f1);
        gameIdsComboBox.setFont(f1);
        uniqueNameField.setFont(f1);
        numOfPlayersField.setFont(f1);
        printAllBtn.setFont(f1);
        printLab.setFont(f1);

        // combo box set up
        initIdComboComboBox(IDs);
        gameTypesComboBox.setSelectedIndex(0);
        gameIdsComboBox.setSelectedIndex(0);

        // adding buttons to the menu panel
        menuPanel.add(addGame);
        menuPanel.add(removeGame);
        menuPanel.add(editGame);
        menuPanel.add(viewGame);
        menuPanel.add(printAllBtn);

        // Games combo box
        comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.X_AXIS));
        comboBoxPanel.add(chooseGameLab);
        comboBoxPanel.add(gameTypesComboBox);

        // Ids combo box
        idComboBoxPanel.setLayout(new BoxLayout(idComboBoxPanel, BoxLayout.X_AXIS));
        idComboBoxPanel.add(gameIdLab);
        idComboBoxPanel.add(gameIdsComboBox);


        // setting the layout of the panels
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));
        panelGame.setLayout(new BoxLayout(panelGame, BoxLayout.PAGE_AXIS));

        // Game labels and input fields
        panelGame.add(uniqueNameLab);
        panelGame.add(uniqueNameField);
        panelGame.add(numOfPlayersLab);
        panelGame.add(numOfPlayersField);
        panelGame.add(playGameBtn);
        panelGame.add(warning);

        // make print area scrollable
        printPanel.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(printArea);
        printPanel.add(printLab, BorderLayout.NORTH);
        printPanel.add(scroll, BorderLayout.CENTER);

        contentPane.add(menuPanel);
        contentPane.add(idComboBoxPanel);
        contentPane.add(comboBoxPanel);

        contentPane.add(mainPanel);
        mainPanel.add(panelGame);
        contentPane.add(printPanel);

        this.setVisible(true);
    }

    /*
    Method is used to reset the Ids combo box every time the number of games changes
     */
    public void initIdComboComboBox(int ids) {
        gameIdsComboBox.removeAllItems();
        for(int i = 0; i < ids; i++) {
            gameIdsComboBox.addItem(i);
        }
    }

    public void setWindowsListener(WindowListener w)
    {
        this.addWindowListener(w);
    }

    public void setWarning(String warnMsg) {
        warning.setText("***Warning*** " + warnMsg);
    }


    public JButton getAddGame() {
        return addGame;
    }

    public void setAddGame(JButton addGame) {
        this.addGame = addGame;
    }

    public JButton getRemoveGame() {
        return removeGame;
    }

    public void setRemoveGame(JButton removeGame) {
        this.removeGame = removeGame;
    }

    public JButton getEditGame() {
        return editGame;
    }

    public void setEditGame(JButton editGame) {
        this.editGame = editGame;
    }

    public JButton getViewGame() {
        return viewGame;
    }

    public void setViewGame(JButton viewGame) {
        this.viewGame = viewGame;
    }

    public JButton getPlayGameBtn() {
        return playGameBtn;
    }

    public void setPlayGameBtn(JButton playGameBtn) {
        this.playGameBtn = playGameBtn;
    }

    public JLabel getChooseGameLab() {
        return chooseGameLab;
    }

    public void setChooseGameLab(JLabel chooseGameLab) {
        this.chooseGameLab = chooseGameLab;
    }

    public JLabel getUniqueNameLab() {
        return uniqueNameLab;
    }

    public void setUniqueNameLab(JLabel uniqueNameLab) {
        this.uniqueNameLab = uniqueNameLab;
    }

    public JLabel getNumOfPlayersLab() {
        return numOfPlayersLab;
    }

    public void setNumOfPlayersLab(JLabel numOfPlayersLab) {
        this.numOfPlayersLab = numOfPlayersLab;
    }

    public JLabel getWarning() {
        return warning;
    }

    public void setWarning(JLabel warning) {
        this.warning = warning;
    }

    public String[] getGameTypes() {
        return gameTypes;
    }

    public void setGameTypes(String[] gameTypes) {
        this.gameTypes = gameTypes;
    }

    public JComboBox getGameTypesComboBox() {
        return gameTypesComboBox;
    }

    public void setGameTypesComboBox(JComboBox gameTypesComboBox) {
        this.gameTypesComboBox = gameTypesComboBox;
    }

    public JTextField getUniqueNameField() {
        return uniqueNameField;
    }

    public void setUniqueNameField(JTextField uniqueNameField) {
        this.uniqueNameField = uniqueNameField;
    }

    public JTextField getNumOfPlayersField() {
        return numOfPlayersField;
    }

    public void setNumOfPlayersField(JTextField numOfPlayersField) {
        this.numOfPlayersField = numOfPlayersField;
    }

    public JButton getPrintAllBtn() {
        return printAllBtn;
    }

    public void setPrintAllBtn(JButton printAllBtn) {
        this.printAllBtn = printAllBtn;
    }

    public JLabel getPrintLab() {
        return printLab;
    }

    public void setPrintLab(JLabel printLab) {
        this.printLab = printLab;
    }

    public JTextArea getPrintArea() {
        return printArea;
    }

    public void setPrintArea(JTextArea printArea) {
        this.printArea = printArea;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public JPanel getPanelGame() {
        return panelGame;
    }

    public void setPanelGame(JPanel panelGame) {
        this.panelGame = panelGame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getPrintPanel() {
        return printPanel;
    }

    public void setPrintPanel(JPanel printPanel) {
        this.printPanel = printPanel;
    }

    public JComboBox getGameIdsComboBox() {
        return gameIdsComboBox;
    }

    public void setGameTypesComboBox(String gameType) {
        for (int i = 0; i< gameTypes.length; i++) {
            if (gameTypes[0].equals(gameType)){
                gameIdsComboBox.setSelectedIndex(i-1);
            }
        }
    }
}
