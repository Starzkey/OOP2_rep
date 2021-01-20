package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class HighScoreView extends JPanel {

    //Attributes
    private JButton returnButton;
    private JLabel highScoreLabel;
    // private JTable highScoreTabelle;

    //Constructor
    public HighScoreView() {
        init();
    }

    //Methods
    public void init() {
        highScoreLabel = new JLabel("Highscores");
        returnButton = new JButton("Return");
        //    highScoreTabelle = new JTable("Highscores")
        add(highScoreLabel);
        add(returnButton);
    }

    //register-Methods
    public void registerReturnButtonListener(ActionListener listener) {
        returnButton.addActionListener(listener);
    }

}
