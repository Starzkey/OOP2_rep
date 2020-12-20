package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartView extends JPanel {

    //Attributes
    private JButton newGame;
    private JButton highScore;
    private JFrame frame;

    //Constructors
    public StartView(JFrame frame) {

        this.frame = frame;


        init();
    }

    //Methods
    private void init() {
        JLabel welcomeText = new JLabel("Herzlich Willkommen bei Cards of Legends!");
        newGame = new JButton("Neues Spiel");
        highScore = new JButton("Highscores");
        add(welcomeText);
        add(newGame);
        add(highScore);
    }

    public void registerNewGameListener(ActionListener listener) {
        newGame.addActionListener(listener);
    }
    public void registerHighScoreListener(ActionListener listener) {
        highScore.addActionListener(listener);
    }
}
