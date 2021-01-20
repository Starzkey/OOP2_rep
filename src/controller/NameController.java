package controller;

import model.CardLibrary;
import model.Mission;
import model.Player;
import utils.MissionGenerator;
import view.MainMenuView;
import view.NameView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class NameController {
    //Player Attributes
    String playerName;
    int playerBalance;
    //Attributes
    private NameView view;
    private JFrame frame;
    private Player player;

    //Contstructors
    public NameController(NameView view, JFrame frame) {
        this.view = view;
        this.frame = frame;

        this.view.registerNameButtonListener(e -> onSavePlayerName(view.getNameField()));

    }

    //Methods

    public void onSavePlayerName(JTextField nameField) { //Erstellt Spieler und setzt Balance auf 1000
        playerName = nameField.getText();
        playerBalance = 1000;

        player = new Player(playerName, playerBalance, new ArrayList<>());
        CardLibrary cardLibrary = new CardLibrary();

        ArrayList<Mission> allMissions = loadMissions();
        ArrayList<Mission> currentMissions = new ArrayList<>();

        Collections.shuffle(allMissions);

        for (int i = 0; i < 3; i++) {

            currentMissions.add(allMissions.get(i));

        }

        MainMenuView mainMenuView = new MainMenuView(player, currentMissions);
        frame.setContentPane(mainMenuView);
        new MainMenuController(mainMenuView, frame, player, currentMissions);
        frame.setVisible(true);

    }

    public ArrayList<Mission> loadMissions() {

        ArrayList<Mission> allMissions = new ArrayList<>();

        Mission thiefMission = MissionGenerator.generateRandomMission();
        allMissions.add(thiefMission);

        Mission armsMission = MissionGenerator.generateRandomMission();
        allMissions.add(armsMission);

        Mission armsMission2 = MissionGenerator.generateRandomMission();
        allMissions.add(armsMission2);

        return allMissions;
    }
}
