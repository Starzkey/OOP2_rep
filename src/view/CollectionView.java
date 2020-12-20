package view;

import model.Card;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CollectionView extends JPanel {

    //Attributes
    private JFrame frame;
    private JButton returnButton;
    private CardListView cardListView;
    private JLabel collectionWelcome;
    private ArrayList<Card> cardList;


    //Constructors
    public CollectionView(ArrayList<Card> playerCollection, JFrame frame) {

        this.cardList = playerCollection;
        this.frame = frame;

        init();
    }

    //Methods
    public void init() {

        returnButton = new JButton("Return");
        cardListView = new CardListView(cardList, frame);


        add(returnButton);
        add(cardListView);
    }

    //register-Methods
    public void registerReturnButtonListener(ActionListener listener) {
        returnButton.addActionListener(listener);
    }

}
