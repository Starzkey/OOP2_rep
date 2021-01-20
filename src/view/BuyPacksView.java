package view;

import model.Player;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BuyPacksView extends JPanel {

    //Attributes
    private JButton returnButton;
    private JLabel balanceOverview;
    private Player player;
    private JButton buyPack1;
    private JButton buyPack2;
    private JLabel welcomeLabel;

    //Constructors
    public BuyPacksView(Player player) {
        this.player = player;

        init();
    }

    //Methods
    public void init() {

        balanceOverview = new JLabel("Balance: " + player.getBalance());
        returnButton = new JButton("Return");
        buyPack1 = new JButton("Buy Pack 1");
        welcomeLabel = new JLabel("Kaufe hier deine Karten! ");

        add(balanceOverview);
        add(returnButton);
        add(buyPack1);
        add(welcomeLabel);

    }

    public JLabel getWelcomeLabel() {
        return welcomeLabel;
    }

    //register-Methods
    public void registerReturnButtonListener(ActionListener listener) {
        returnButton.addActionListener(listener);
    }

    public void registerBuyPack1Listener(ActionListener listener) {
        buyPack1.addActionListener(listener);
    }

}
