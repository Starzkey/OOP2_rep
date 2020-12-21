package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CardView extends JPanel {

    //Attributes
    JFrame frame;

    private int value;
    private String rarity;
    private String cardName;
    private String[] categories;

    private JToggleButton markCard;
    private JButton sellCard;
    private JLabel valueOverview;
    private JLabel cardNameOverview;
    private JList<String> categoriesOverview;
    private JLabel rarityOverview;


    //Constructors
    public CardView(int value, String cardName, String[] categories, String rarity, JFrame frame) {

        this.frame = frame;
        this.value = value;
        this.rarity = rarity;
        this.cardName = cardName;
        this.categories = categories;

        init();
    }

    //Methods
    public void init() {

        BorderLayout l = new BorderLayout();
        markCard = new JToggleButton("select Card");
        sellCard = new JButton("sell Card");
        valueOverview = new JLabel(String.valueOf(value));
        cardNameOverview = new JLabel(cardName);
        categoriesOverview = new JList<>(categories);
        rarityOverview = new JLabel(rarity);

        add(valueOverview);
        add(cardNameOverview);
        add(categoriesOverview);
        add(rarityOverview);
        add(markCard);
        add(sellCard);
    }

    public JToggleButton getMarkCard() {
        return markCard;
    }

    public void registerMarkCardListener(ActionListener listener) {
        markCard.addActionListener(listener);
    }

    public void registerSellCardListener(ActionListener listener) {
        sellCard.addActionListener(listener);
    }

    public void registerMarkCardItemListener(ItemListener itemListener) {markCard.addItemListener(itemListener);}


}
