package controller;

import main.Main;
import model.Card;
import model.CardLibrary;
import model.Player;
import view.BuyPacksView;
import view.MainMenuView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

import static model.Card.toStringCategories;

public class BuyPacksController  {

    //Attributes
    private BuyPacksView view;
    private JFrame frame;
    private Player player;
    private CardLibrary cardLibrary;
    private ArrayList<Card> drawnCards = new ArrayList<>();

    private double randNumber;
    private StringBuilder stringBuilder;
    private String toString;




    //Constructors
    public BuyPacksController(BuyPacksView view, JFrame frame, Player player) {
        cardLibrary = new CardLibrary(); //Frage an Michi: Kann man das bereits bei Spielstart laden?
        this.view = view;
        this.frame = frame;
        this.player = player;

        this.view.registerReturnButtonListener(e -> onToMainMenuView());
        this.view.registerBuyPack1Listener(e -> onBuyPack1());
    }

    //Methods
    public void onToMainMenuView() {
        MainMenuView mainMenuView = new MainMenuView(player, frame);
        frame.setContentPane(mainMenuView);
        new MainMenuController(mainMenuView, frame, player);
        frame.setVisible(true); //Immer am Ende der Methode notwendig, damit Ansicht aktualisiert wird und man das neue Panel sieht.
    }

    public void onBuyPack1() {
        if(player.playerBalance>=100) {

            player.playerBalance -= 100;


            for(int i=0; i < 5; i++) {

                randNumber = Math.random()*100+1;

                if(randNumber<=60) {
                    Collections.shuffle(cardLibrary.getCommonCards());
                    drawnCards.add(cardLibrary.getCommonCards().get(0));
                    player.playerCollection.add(cardLibrary.getCommonCards().get(0));

                } else if((randNumber>60) && (randNumber <= 95)) {
                    Collections.shuffle(cardLibrary.getUncommonCards());
                    drawnCards.add(cardLibrary.getUncommonCards().get(0));
                    player.playerCollection.add(cardLibrary.getUncommonCards().get(0));

                } else if(randNumber > 95) {
                    Collections.shuffle(cardLibrary.getRareCards());
                    drawnCards.add(cardLibrary.getRareCards().get(0));
                    player.playerCollection.add(cardLibrary.getRareCards().get(0));
                }
            }

            String[] columnNames = {"Card Name", "Value", "Categories", "Rarity"};
            Object[][] rowData = new Object[5][4];
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 4; j++) {
                rowData[i] = new Object[] {drawnCards.get(i).getCardName(), drawnCards.get(i).getValue(),
                        toStringCategories(drawnCards.get(i).getCategories()), drawnCards.get(i).getRarity()};
                }
            }

            JTable drawnCardsTable = new JTable (rowData, columnNames);
            drawnCardsTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
            drawnCardsTable.setFillsViewportHeight(true);

            JScrollPane scrollPane = new JScrollPane(drawnCardsTable);

            BuyPacksView buyPacksView = new BuyPacksView(player);
            buyPacksView.remove(buyPacksView.getWelcomeLabel());
            buyPacksView.add(scrollPane);
            frame.setContentPane(buyPacksView);
            new BuyPacksController(buyPacksView, frame, player);
            frame.setVisible(true);
        }

    }

    public void onBuyPack2() {

    }

    public static String returnDrawnCards(ArrayList<Card> drawnCards) { //Nicht mehr benötigt, stattdessen mit JTable gelöst.

        StringBuilder stringBuilder = new StringBuilder();
        String toString;

        for (int i = 0; i < drawnCards.size(); i++) {
            stringBuilder.append(i + 1).append(". gezogene Karte: ").append(drawnCards.get(i).getCardName()).append("\n");
        }

        toString = stringBuilder.toString();
        return "Received Cards: " + "\n" + toString;

    }

    public ArrayList<Card> getDrawnCards() {
        return drawnCards;
    }

}
