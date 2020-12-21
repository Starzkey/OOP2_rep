package view;

import model.Card;
import model.CardLibrary;
import model.Player;

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
    private Player player;
    private JList selectedCardsOverview;
    private ArrayList<Card> selectedCards;
    private JButton sellSelectedCards;


    //Constructors
    public CollectionView(Player player, JFrame frame) {

        this.player = player;
        this.cardList = player.playerCollection;
        this.frame = frame;

        selectedCards = new ArrayList<Card>();



        init();
    }

    public CollectionView(Player player, JFrame frame, ArrayList<Card> selectedCards) {

        this.player = player;
        this.cardList = player.playerCollection;
        this.frame = frame;
        this.selectedCards = selectedCards;

        init();
    }


    //Methods
    public void init() {

        selectedCardsOverview = new JList(getCardNames().toArray());
        returnButton = new JButton("Return");
        cardListView = new CardListView(player, frame, selectedCards);
        sellSelectedCards = new JButton("sell selected Cards");

        add(returnButton);
        add(cardListView);
        add(selectedCardsOverview);
        add(sellSelectedCards);
    }

    public ArrayList<String> getCardNames() {

        ArrayList<String> cardNames = new ArrayList<>();

        for(int i = 0; i<selectedCards.size(); i++) {
            cardNames.add(selectedCards.get(i).getCardName());
        }
        return cardNames;
    }

    //register-Methods
    public void registerReturnButtonListener(ActionListener listener) {
        returnButton.addActionListener(listener);
    }

}
