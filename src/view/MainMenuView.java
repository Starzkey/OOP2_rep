package view;

import model.Mission;
import model.Player;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class MainMenuView extends JPanel implements PropertyChangeListener {

    //TODO We're doing missions. It's way easier that way. On the Main menu, random sub Panels "missions" will be displayed, f.e. find 5 warriors, etc. these can be turned in for points.

    //Attributes
    private JLabel balanceOverview;
    private JButton toCollection;
    private JButton toBuyPack;
    private Player player;
    private MissionsView missionsView;
    private ArrayList<Mission> currentMissions;

    //Constructors
    public MainMenuView(Player player, ArrayList<Mission> currentMissions) {

        this.player = player;
        this.currentMissions = currentMissions;



        init();

        player.addPropertyChangeListener(this);
    }

    //Methods
    public void init() {


        balanceOverview = new JLabel("Balance: " + player.getBalance());
        toCollection = new JButton("View Collection");
        toBuyPack = new JButton("Buy Packs");

        add(balanceOverview);
        add(toCollection);
        add(toBuyPack);

        MissionsView missionsView = new MissionsView(player, currentMissions);
        add(missionsView);

    }

    //register-Methods

    public void registerToCollectionListener(ActionListener listener) {
        toCollection.addActionListener(listener);
    }

    public void registerToBuyPacksListener(ActionListener listener) {
        toBuyPack.addActionListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()) {
            case "balance" : balanceOverview.setText("Balance: " + evt.getNewValue());
            break;
        }
    }
}
