package controller;

import model.Card;
import model.Mission;
import model.Player;
import view.CollectionView;
import view.MainMenuView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CollectionController {

    //Attributes
    private CollectionView view;
    private JFrame frame;
    private Player player;
    private ArrayList<Mission> currentMissions;

    //Constructors
    public CollectionController(CollectionView view, JFrame frame, Player player, ArrayList<Mission> currentMissions) {
        this.view = view;
        this.frame = frame;
        this.player = player;
        this.currentMissions = currentMissions;

        this.view.registerReturnButtonListener(e -> onToMainMenuView());
        this.view.registerSellSelectedCardsListener(e -> onSellSelectedCards(player));
    }

    //Methods
    private void onToMainMenuView() {
        MainMenuView mainMenuView = new MainMenuView(player, currentMissions);
        frame.setContentPane(mainMenuView);
        new MainMenuController(mainMenuView, frame, player, currentMissions);
        frame.setVisible(true); //Immer am Ende der Methode notwendig, damit Ansicht aktualisiert wird und man das neue Panel sieht.
    }

    private void onSellSelectedCards(Player player) {
        int sum = 0;
        for (Card card : player.getCollection()) {
            if(card.isSelected()){
                sum += card.getValue();
                player.removeCard(card);
            }
        }
        player.setBalance(player.getBalance() + sum);
    }
}
