package controller;

import model.Card;
import model.CardLibrary;
import model.Player;
import view.CardListView;
import view.CardView;
import view.CollectionView;
import view.DialogField;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class CardController {

    private CardView view;
    private JFrame frame;
    private Player player;
    private int cardValue;
    private Card selectedCard;
    private ArrayList<Card> selectedCards;

    public CardController(CardView view, JFrame frame, Player player, Card thisCard, ArrayList<Card> selectedCards) {

        this.selectedCard = thisCard;
        this.view = view;
        this.frame = frame;
        this.player = player;
        this.selectedCard = thisCard;
        this.cardValue = thisCard.getValue();
        this.selectedCards = selectedCards;


        //this.view.registerMarkCardListener(e -> onMarkCard(thisCard, selectedCards));
        this.view.registerSellCardListener(e -> onSellCard(player, thisCard));

        this.view.registerMarkCardItemListener(e -> {

            int state = e.getStateChange();

            if(state == ItemEvent.SELECTED) {

                onMarkCard(thisCard, selectedCards);

                view.getMarkCard().setText("Unselect Card");

                System.out.println("a");

            } else {

                onDeselectCard(thisCard, selectedCards);

                System.out.println("b");

            }
        });


    }


    public void onMarkCard(Card thisCard, ArrayList<Card> selectedCards) {

        if(selectedCards.contains(thisCard)) {

        } else {
            selectedCards.add(thisCard);
        }

        CollectionView collectionView = new CollectionView(player, frame, selectedCards);
        frame.setContentPane(collectionView);
        new CollectionController(collectionView, frame, player);
        frame.setVisible(true);


    }

    public void onDeselectCard(Card thisCard, ArrayList<Card> selectedCards) {

        if(selectedCards.contains(thisCard)) {
            selectedCards.remove(thisCard);
        } else {

        }

    }

    public void onSellCard(Player player, Card selectedCard) {

        Object[] options = new Object[] {"Sell the damned card", "Changed my mind"};
        DialogField sellOneAnswer = new DialogField(frame, "The vendor looks at you with a hopeful grin. \n" + "Obviously, the card is worth a lot more under the right circumstances. \n" +"Are you sure you want to get rid of it?", "Selling a single card", options);
        int playerAnswer = sellOneAnswer.getPlayerAnswer();

        if(playerAnswer==0) {
            player.playerBalance += cardValue;
            player.playerCollection.remove(selectedCard);
            CollectionView collectionView = new CollectionView(player, frame);
            frame.setContentPane(collectionView);
            new CollectionController(collectionView, frame, player);
            frame.setVisible(true);
        }

    }
}
