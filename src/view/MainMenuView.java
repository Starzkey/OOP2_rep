package view;

import controller.NameController;
import model.Player;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JPanel {

    //Attributes
    private JLabel balanceOverview;
    private JButton toCollection;
    private JButton toBuyPack;
    private Player player;

    //Constructors
    public MainMenuView(Player player) {

        this.player = player;

        init();

    }

    //Methods
    public void init() {

        balanceOverview = new JLabel("Balance: " + player.getPlayerBalance());
        toCollection = new JButton("View Collection");
        toBuyPack = new JButton("Buy Packs");

        add(balanceOverview);
        add(toCollection);
        add(toBuyPack);

    }

    //register-Methods

    public void registerToCollectionListener(ActionListener listener) {
        toCollection.addActionListener(listener);
    }
    public void registerToBuyPacksListener(ActionListener listener) {
        toBuyPack.addActionListener(listener);
    }

}
