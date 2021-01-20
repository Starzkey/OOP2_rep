package view;

import controller.MissionController;
import model.Mission;
import model.Player;

import javax.swing.*;
import java.util.ArrayList;

public class MissionsView extends JPanel {

    private Player player;

    public MissionsView(Player player, ArrayList<Mission> currentMissions) {

        this.player = player;

        for (Mission mission : currentMissions) {
            MissionView view = new MissionView(mission, player);
            new MissionController(view, player, mission);
            add(view);

        }
    }

    //Methods

}
