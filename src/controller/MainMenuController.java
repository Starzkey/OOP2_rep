package controller;

import model.Card;
import model.Mission;
import model.Player;
import view.BuyPacksView;
import view.CardListView;
import view.CollectionView;
import view.MainMenuView;

import javax.swing.*;
import java.util.ArrayList;

public class MainMenuController {

    //Attributes
    private MainMenuView view;
    private JFrame frame;
    private Player player;
    private ArrayList<Mission> currentMissions;
    private ArrayList<CardListView> cardListViews;
    private ArrayList<Card> selectedCards;

    //Constructors
    public MainMenuController(MainMenuView view, JFrame frame, Player player, ArrayList<Mission> currentMissions) {
        this.view = view;
        this.frame = frame;
        this.player = player;
        this.currentMissions = currentMissions;

        this.view.registerToCollectionListener(e -> onToCollection());
        this.view.registerToBuyPacksListener(e -> onToBuyPacks());
    }

    //Methods
    public void onToCollection() {

        CollectionView collectionView = new CollectionView(player, frame, currentMissions);
        frame.setContentPane(collectionView);
        new CollectionController(collectionView, frame, player, currentMissions);
        frame.setVisible(true);

    }

    public void onToBuyPacks() {

        BuyPacksView buyPacksView = new BuyPacksView(player);
        frame.setContentPane(buyPacksView);
        new BuyPacksController(buyPacksView, frame, player, currentMissions);
        frame.setVisible(true);

    }

}
