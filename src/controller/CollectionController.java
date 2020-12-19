package controller;

import model.CardLibrary;
import model.Player;
import view.CollectionView;
import view.MainMenuView;

import javax.swing.*;

public class CollectionController {

    //Attributes
    private CollectionView view;
    private JFrame frame;
    private Player player;
    private CardLibrary cardLibrary;

    //Constructors
    public CollectionController(CollectionView view, JFrame frame, Player player, CardLibrary cardLibrary) {
        this.view = view;
        this.frame = frame;
        this.player = player;
        this.cardLibrary = cardLibrary;

        this.view.registerReturnButtonListener(e -> onToMainMenuView());

    }

    //Methods
    public void onToMainMenuView() {
        MainMenuView mainMenuView = new MainMenuView(player);
        frame.setContentPane(mainMenuView);
        new MainMenuController(mainMenuView, frame, player, cardLibrary);
        frame.setVisible(true); //Immer am Ende der Methode notwendig, damit Ansicht aktualisiert wird und man das neue Panel sieht.
    }

}
