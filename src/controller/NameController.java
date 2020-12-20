package controller;

import model.CardLibrary;
import model.Player;
import model.Card;
import view.MainMenuView;
import view.NameView;

import javax.swing.*;
import java.util.ArrayList;

public class NameController {
    //Attributes
    private NameView view;
    private JFrame frame;

    private CardLibrary cardLibrary;

    //Player Attributes
    String playerName;
    int playerBalance;
    ArrayList<Card> playerCollection;
    private Player player;

    //Contstructors
    public NameController(NameView view, JFrame frame, CardLibrary cardLibrary) {
        this.view = view;
        this.frame = frame;
        this.cardLibrary = cardLibrary;

        this.view.registerNameButtonListener(e -> onSavePlayerName(view.getNameField()));

    }

    //Methods

    public void onSavePlayerName(JTextField nameField) { //Erstellt Spieler und setzt Balance auf 1000
        playerName = nameField.getText();
        playerBalance = 1000;

        player = new Player(playerName, playerBalance, playerCollection);


        MainMenuView mainMenuView = new MainMenuView(player, frame);
        frame.setContentPane(mainMenuView);
        new MainMenuController(mainMenuView, frame, player, cardLibrary);
        frame.setVisible(true);

    }



    public void onToMainMenu() {
         //Methode in onSavePlayerName() geschoben, weil pro JElement nur ein ActionListener registriert werden kann.

    }

}
