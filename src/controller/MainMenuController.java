package controller;

import model.CardLibrary;
import model.Player;
import view.*;

import javax.swing.*;

public class MainMenuController {

    //Attributes
    private MainMenuView view;
    private JFrame frame;
    private Player player;
    private CardLibrary cardLibrary;

    //Constructors
    public MainMenuController(MainMenuView view, JFrame frame, Player player, CardLibrary cardLibrary) {
        this.view = view;
        this.frame = frame;
        this.player = player;
        this.cardLibrary = cardLibrary;

        this.view.registerToCollectionListener(e -> onToCollection());
        this.view.registerToBuyPacksListener(e -> onToBuyPacks());

    }

    //Methods

    public void onToCollection() {

        CollectionView collectionView = new CollectionView(player.playerCollection, frame);
        frame.setContentPane(collectionView);
        new CollectionController(collectionView, frame, player, cardLibrary);
        frame.setVisible(true);

    }

    public void onToBuyPacks() {

        BuyPacksView buyPacksView = new BuyPacksView(player);
        frame.setContentPane(buyPacksView);
        new BuyPacksController(buyPacksView, frame, player, cardLibrary);
        frame.setVisible(true);

    }


}
