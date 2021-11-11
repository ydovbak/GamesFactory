package com.tus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;

public class GUIView extends JFrame {
    // font for the GUI
    Font  f1  = new Font(Font.SERIF, Font.PLAIN,  20);

    // Game buttons and labels
    private JButton addGame = new JButton("Add Game");
    private JButton removeGame = new JButton("Remove Game");
    private JButton editGame = new JButton("Edit Game");
    private JButton viewGame = new JButton("View Game");
    private JButton playGameBtn = new JButton("Play");

    private JLabel gameIdLab = new JLabel("Game ID (Edit/Remove/View)");
    private JLabel chooseGameLab = new JLabel("Chose the game:");
    private JLabel uniqueNameLab = new JLabel("Unique Name:");
    private JLabel numOfPlayersLab = new JLabel("Number of players:");
    private JLabel warning = new JLabel("");

    private JTextField uniqueNameField = new JTextField();
    private JTextField numOfPlayersField = new JTextField();

    private String[] gameTypes = { "Uno", "Checkers", "Chess", "Poker" };
    private JComboBox gameTypesComboBox = new JComboBox(gameTypes);
    private JComboBox gameIdsComboBox = new JComboBox();

    // print area
    private JButton printAllBtn = new JButton("Print All");
    private JLabel printLab = new JLabel("Print Area:");
    private JTextArea printArea = new JTextArea();

    // panels
    private JPanel menuPanel = new JPanel();
    private JPanel comboBoxPanel = new JPanel();
    private JPanel idComboBoxPanel = new JPanel();
    private JPanel gamePanel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JPanel printPanel = new JPanel();

    // container for everything
    private Container contentPane = this.getContentPane();

    public GUIView(int numOfIds)
    {
        // initialise the ComboBox containing IDs
        initIdComboComboBox(numOfIds);

        // basic window setup
        this.setTitle("Games Factory");
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

        // Games combo box
        comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.X_AXIS));
        comboBoxPanel.add(chooseGameLab);
        comboBoxPanel.add(gameTypesComboBox);
        gameTypesComboBox.setSelectedIndex(0);

        // Ids combo box
        idComboBoxPanel.setLayout(new BoxLayout(idComboBoxPanel, BoxLayout.X_AXIS));
        idComboBoxPanel.add(gameIdLab);
        idComboBoxPanel.add(gameIdsComboBox);
        gameIdsComboBox.setSelectedIndex(0);

        // adding buttons to the menu panel
        menuPanel.add(addGame);
        menuPanel.add(removeGame);
        menuPanel.add(editGame);
        menuPanel.add(viewGame);
        menuPanel.add(printAllBtn);

        // setting the layout of the panels
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.PAGE_AXIS));

        // Game labels and input fields
        gamePanel.add(uniqueNameLab);
        gamePanel.add(uniqueNameField);
        gamePanel.add(numOfPlayersLab);
        gamePanel.add(numOfPlayersField);
        gamePanel.add(playGameBtn);
        gamePanel.add(warning);

        // make print area scrollable
        printPanel.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(printArea);
        printPanel.add(printLab, BorderLayout.NORTH);
        printPanel.add(scroll, BorderLayout.CENTER);

        // set up the content pane with multiple panels
        mainPanel.add(gamePanel);
        contentPane.add(menuPanel);
        contentPane.add(idComboBoxPanel);
        contentPane.add(comboBoxPanel);
        contentPane.add(mainPanel);
        contentPane.add(printPanel);

        this.setVisible(true);
    }

    /*
    Method is used to reset the Ids-ComboBox every time the number of games changes
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
        warning.setText(warnMsg);
    }

    public JButton getAddGame() {
        return addGame;
    }

    public JButton getRemoveGame() {
        return removeGame;
    }

    public JButton getEditGame() {
        return editGame;
    }

    public JButton getViewGame() {
        return viewGame;
    }

    public JButton getPlayGameBtn() {
        return playGameBtn;
    }

    public JComboBox getGameTypesComboBox() {
        return gameTypesComboBox;
    }

    public JTextField getUniqueNameField() {
        return uniqueNameField;
    }

    public JTextField getNumOfPlayersField() {
        return numOfPlayersField;
    }

    public JButton getPrintAllBtn() {
        return printAllBtn;
    }

    public JTextArea getPrintArea() {
        return printArea;
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
