package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CollectionView extends JPanel {

    //Attributes
    private JButton returnButton;
    private JLabel collectionWelcome;


    //Constructors
    public CollectionView() {
        init();
    }

    //Methods
    public void init() {

        returnButton = new JButton("Return");
        add(returnButton);
    }

    //register-Methods
    public void registerReturnButtonListener(ActionListener listener) {
        returnButton.addActionListener(listener);
    }

}
