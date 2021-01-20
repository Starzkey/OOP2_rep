package view;

import controller.CardController;
import model.Card;
import model.Mission;
import model.Player;
import utils.ListUtil;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionView extends JPanel implements PropertyChangeListener { //TODO Collection should be streamlined: Sort after rarity + only show same cards once (with amount label)

    //TODO Copy off of Hearthstone - make all cards visible, fill them out if at least 1 is owned, if multiple ones, amount them

    //Constants
    private static final int CARDS_PER_PAGE = 12;

    //Attributes
    private JFrame frame;
    private Player player;

    private JButton returnButton;
    private JButton prevPageButton;
    private JButton nextPageButton;
    private JButton sellSelectedCardsButton;

    private JLabel balanceOverview;
    private JLabel pageIndexLabel;

    private JList<String> selectedCardsOverview;
    private ArrayList<Card> collection;
    private DefaultListModel<String> selectedCardsList;
    private ArrayList<Mission> currentMissions;
    private CardListView cardListView;

    private int pageIndex;

    //Constructors
    public CollectionView(Player player, JFrame frame, ArrayList<Mission> currentMissions) {
        this.player = player;
        this.frame = frame;
        this.currentMissions = currentMissions;
        this.selectedCardsList = new DefaultListModel<>();
        this.pageIndex = 0;

        init();

        player.addPropertyChangeListener(this);
    }

    //Methods
    public void init() {
        selectedCardsOverview = new JList<>(selectedCardsList);
        balanceOverview = new JLabel("Balance:");
        returnButton = new JButton("Return to Main Menu");
        sellSelectedCardsButton = new JButton("Sell Selected Cards");
        prevPageButton = new JButton("Previous Page");
        nextPageButton = new JButton("Next Page");
        prevPageButton.addActionListener(e -> onPrevPage());
        nextPageButton.addActionListener(e -> onNextPage());

        pageIndexLabel = new JLabel(String.valueOf(pageIndex + 1));
        cardListView = new CardListView();

        updateBalanceLabel(player.getBalance());
        updateCardList(player.getCollection());

        add(balanceOverview);
        add(returnButton);
        add(selectedCardsOverview);
        add(sellSelectedCardsButton);
        add(cardListView);
        add(prevPageButton);
        add(pageIndexLabel);
        add(nextPageButton);

        frame.setVisible(true);
    }

    private void updateBalanceLabel(int balance) {
        balanceOverview.setText("Balance: " + balance);
    }

    private void updatePageIndexLabel(int index, int size) {
        int i = index + 1;
        pageIndexLabel.setText("(" + i + "/" + size + ")");
    }

    private void updateSelectedCardList(ArrayList<Card> cards) {
        selectedCardsList.removeAllElements();
        selectedCardsList.addAll(cards.stream()
                .filter(Card::isSelected)
                .map(Card::getName)
                .collect(Collectors.toList()));
    }

    private void updateCardList(ArrayList<Card> cards) {
        cardListView.removeAll();
        collection = cards;
        List<List<Card>> collectionPages = ListUtil.partition(cards, CARDS_PER_PAGE); //TODO okay michi des musste mal erklären :p

        //Verify that current page index is <= maximum page index
        pageIndex = Math.min(pageIndex, collectionPages.size() - 1);
        updatePageIndexLabel(pageIndex, collectionPages.size());

        List<Card> page = collectionPages.get(pageIndex);

        page.stream()
                // Map Card to CardView and instantiate controller
                .map((card -> {
                    card.addPropertyChangeListener(this);
                    CardView cardView = new CardView(card, frame, player);
                    new CardController(cardView, frame, player, card);
                    return cardView;
                }))
                // Add all card views of the page to the card list view
                .forEach((cardView) -> {
                    cardListView.add(cardView);
                });

        updateSelectedCardList(cards);
    }

    private void onPrevPage() {
        if (pageIndex > 0) {
            pageIndex--;
            updatePageIndexLabel(pageIndex, collection.size());
            updateCardList(collection);
        }
    }

    private void onNextPage() {
        if (pageIndex < (Math.ceil(player.getCollection().size() / (double) CARDS_PER_PAGE) - 1)) {
            pageIndex++;
            updatePageIndexLabel(pageIndex, collection.size());
            updateCardList(collection);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "balance":
                updateBalanceLabel((int) evt.getNewValue());
                break;
            case "collection":
                updateCardList((ArrayList<Card>) evt.getNewValue());
                break;
            case "selected":
                updateSelectedCardList(collection);
                break;
        }
    }

    //register-Methods
    public void registerReturnButtonListener(ActionListener listener) {
        returnButton.addActionListener(listener);
    }

    public void registerSellSelectedCardsListener(ActionListener listener) {
        sellSelectedCardsButton.addActionListener(listener);
    }
}

