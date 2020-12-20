package view;

import model.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CardListView extends JPanel {

    //Attributes

    private ArrayList<Card> cardList;
    private JFrame frame;

    private JButton prevPage;
    private JButton nextPage;


    //Constructors

    public CardListView(ArrayList<Card> cardList, JFrame frame) {

        this.cardList = cardList;
        this.frame = frame;

        init();
    }

    //Methods
    public void init() {

        GridLayout layout = new GridLayout(6,5);
        setLayout(layout);
        layout.setHgap(5);
        layout.setVgap(5);
        frame.setVisible(true);

        for (Card card : cardList) {
            CardView loadCard = new CardView(card.getValue(), card.getCardName(), card.getCategories(), card.getRarity());
            loadCard.setBorder(BorderFactory.createLineBorder(Color.black));

            add(loadCard);
            frame.setVisible(true);
        }


    }



    //register-Methods

    public void registerprevPageListener(ActionListener listener){
        prevPage.addActionListener(listener); }

    public void registerNextPageListener(ActionListener listener) {
        nextPage.addActionListener(listener);
    }



}
