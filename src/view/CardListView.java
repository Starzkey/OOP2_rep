package view;

import javax.swing.*;
import java.awt.*;

public class CardListView extends JPanel {

    //Attributes

    //Constructors
    public CardListView() {
        init();
    }

    //Methods
    public void init() {
        GridLayout layout = new GridLayout(4, 3);
        setLayout(layout);
        setAlignmentX(10);
        layout.setHgap(5);
        layout.setVgap(5);
    }

    //register-Methods
}
