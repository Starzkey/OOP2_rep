package view;

import javax.swing.*;
import java.awt.*;

public class CardView extends JPanel {

    //Attributes
    private int value;
    private String rarity;
    private String cardName;
    private String[] categories;

    private JButton a;
    private JButton markCard;
    private JButton sellCard;

    //Constructors
    public CardView(int value, String cardName, String[] categories, String rarity) {
        this.value = value;
        this.rarity = rarity;
        this.cardName = cardName;
        this.categories = categories;

        init();
    }

    //Methods

    public void init() {

        BorderLayout l = new BorderLayout();
        a = new JButton("a");

        add(a);
    }


}
