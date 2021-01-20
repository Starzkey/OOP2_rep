package view;

import model.Card;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CardView extends JPanel implements PropertyChangeListener {

    //Attributes
    private JFrame frame;
    private Player player;
    private Card card;
    private JToggleButton selectCard;
    private JButton sellCard;
    private JLabel valueLabel;
    private JLabel nameLabel;
    private JList<String> categories;
    private JLabel rarityLabel;

    //Constructors
    public CardView(Card card, JFrame frame, Player player) {
        this.card = card;
        this.frame = frame;
        this.player = player;

        init();

        this.card.addPropertyChangeListener(this);
    }

    //Methods
    private void init() {
        selectCard = new JToggleButton(card.isSelected() ? "unselect card" : "select card", card.isSelected());

        sellCard = new JButton("sell card");
        valueLabel = new JLabel(String.valueOf(card.getValue()));
        nameLabel = new JLabel(card.getName());
        categories = new JList<String>(Arrays.asList(card.getCategories()).stream().map(category -> category.toString()).toArray(String[]::new));
        rarityLabel = new JLabel(card.getRarity());

        add(valueLabel);
        add(nameLabel);
        add(categories);
        add(rarityLabel);
        add(selectCard);
        add(sellCard);
        setBackground(getRarityColor());
    }

    private Color getRarityColor() {
        switch (card.getRarity()) {
            case "common":
                return Color.gray;
            case "uncommon":
                return Color.cyan;
            case "rare":
                return Color.blue;
            default:
                return Color.white;
        }
    }

    public void registerSelectCardListener(ActionListener listener) {
        selectCard.addActionListener(listener);
    }

    public void registerSellCardListener(ActionListener listener) {
        sellCard.addActionListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "selected":
                selectCard.setSelected((boolean) evt.getNewValue());
                selectCard.setText((boolean) evt.getNewValue() ? "unselect card" : "select card");
        }
    }
}
