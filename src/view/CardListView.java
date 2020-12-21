package view;

import controller.CardController;
import model.Card;
import model.CardLibrary;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CardListView extends JPanel {

    //Attributes

    private ArrayList<Card> cardList;
    private JFrame frame;
    private Player player;
    private ArrayList<Card> selectedCards;

    private JButton prevPage;
    private JButton nextPage;



    //Constructors

    public CardListView(Player player, JFrame frame, ArrayList<Card> selectedCards) {
        this.player = player;
        this.cardList = player.playerCollection;
        this.frame = frame;
        this.selectedCards = selectedCards;

        init();
    }

    //Methods
    public void init() {

        GridLayout layout = new GridLayout(10,10);
        setLayout(layout);
        setAlignmentX(10);
        layout.setHgap(5);
        layout.setVgap(5);
        frame.setVisible(true);

        for (Card card : cardList) {
            CardView loadCard = new CardView(card.getValue(), card.getCardName(), card.getCategories(), card.getRarity(), frame);
            new CardController(loadCard, frame, player, card, selectedCards);

            loadCard.setBorder(BorderFactory.createLineBorder(Color.black));

            add(loadCard);
            frame.setVisible(true);
        }


    }



    //register-Methods

    public void registerPrevPageListener(ActionListener listener){
        prevPage.addActionListener(listener); }

    public void registerNextPageListener(ActionListener listener) {
        nextPage.addActionListener(listener);
    }



}
