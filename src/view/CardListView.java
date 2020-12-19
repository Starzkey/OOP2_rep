package view;

import model.Card;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardListView extends JPanel {

    //Attributes

    private ArrayList<Card> cardList;


    //Constructors

    public CardListView(ArrayList<Card> cardList) {

        this.cardList = cardList;

        init();
    }

    //Methods
    public void init() {
        JScrollPane scrollPane = new JScrollPane();

        JList cardListView = new JList();

        for (Card card : cardList) {
            //TODO

        }

        scrollPane.add(cardListView);

    }

}
