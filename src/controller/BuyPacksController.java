package controller;

import model.Card;
import model.CardLibrary;
import model.Mission;
import model.Player;
import view.BuyPacksView;
import view.MainMenuView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static model.Card.toStringCategories;

public class BuyPacksController { //TODO cards won't be drawn randomly, but a dialog window will popup events via questions with answer options(randomly) very rare events - questions - when answered correctly, will result in very rare cards

    //Attributes
    private BuyPacksView view;
    private JFrame frame;
    private Player player;
    private CardLibrary cardLibrary;
    private ArrayList<Card> drawnCards = new ArrayList<>();
    private ArrayList<Mission> currentMissions;

    private double randNumber;
    private StringBuilder stringBuilder;
    private String toString;

    //Constructors
    public BuyPacksController(BuyPacksView view, JFrame frame, Player player, ArrayList<Mission> currentMissions) {
        this.view = view;
        this.frame = frame;
        this.player = player;
        this.currentMissions = currentMissions;

        this.view.registerReturnButtonListener(e -> onToMainMenuView());
        this.view.registerBuyPack1Listener(e -> onBuyPack1());

    }

    public static String returnDrawnCards(ArrayList<Card> drawnCards) { //Nicht mehr benötigt, stattdessen mit JTable gelöst.

        StringBuilder stringBuilder = new StringBuilder();
        String toString;

        for (int i = 0; i < drawnCards.size(); i++) {
            stringBuilder.append(i + 1).append(". gezogene Karte: ").append(drawnCards.get(i).getName()).append("\n");
        }

        toString = stringBuilder.toString();
        return "Received Cards: " + "\n" + toString;

    }

    //Methods
    public void onToMainMenuView() {

        MainMenuView mainMenuView = new MainMenuView(player, currentMissions);
        frame.setContentPane(mainMenuView);
        new MainMenuController(mainMenuView, frame, player, currentMissions);

        frame.setVisible(true); //Immer am Ende der Methode notwendig, damit Ansicht aktualisiert wird und man das neue Panel sieht.
    }

    public void onBuyPack1() {
        if (player.getBalance() >= 100) {

            int playerBalance = player.getBalance();
            player.setBalance(playerBalance -= 100);

            for (int i = 0; i < 5; i++) {

                CardLibrary cardLibrary = new CardLibrary();

                randNumber = Math.random() * 100 + 1;

                if (randNumber <= 60) {

                    ArrayList<Card> commonCards = cardLibrary.getCommonCards();

                    Collections.shuffle(commonCards);
                    Card drawnCard = commonCards.get(0);
                    drawnCards.add(drawnCard);
                    player.addCard(drawnCard);


                    /* for(Card card : player.collection) {
                        boolean cardOwned = true;
                        if (card.equals(drawnCard)) {

                            int cardAmount = card.getAmount();
                            card.setAmount(cardAmount += 1);
                            cardOwned = false;
                            System.out.println("Card: " + card.getName() + "Amount: " + card.getAmount());

                        }
                        }

                    if(!cardOwned) {


                    }  TODO Sounds good, doesnt work */

                } else if ((randNumber > 60) && (randNumber <= 95)) {
                    Collections.shuffle(cardLibrary.getUncommonCards());
                    drawnCards.add(cardLibrary.getUncommonCards().get(0));
                    player.addCard(cardLibrary.getUncommonCards().get(0));

                } else if (randNumber > 95) {
                    Collections.shuffle(cardLibrary.getRareCards());
                    drawnCards.add(cardLibrary.getRareCards().get(0));
                    player.addCard(cardLibrary.getRareCards().get(0));
                }
            }

            String[] columnNames = {"Card Name", "Value", "Categories", "Rarity"};
            Object[][] rowData = new Object[5][4];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    rowData[i] = new Object[]{drawnCards.get(i).getName(), drawnCards.get(i).getValue(),
                            toStringCategories(drawnCards.get(i).getCategories()), drawnCards.get(i).getRarity()};
                }
            }

            JTable drawnCardsTable = new JTable(rowData, columnNames);
            drawnCardsTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
            drawnCardsTable.setFillsViewportHeight(true);

            BuyPacksView buyPacksView = new BuyPacksView(player);
            buyPacksView.remove(buyPacksView.getWelcomeLabel());
            buyPacksView.add(drawnCardsTable);
            frame.setContentPane(buyPacksView);
            new BuyPacksController(buyPacksView, frame, player, currentMissions);
            frame.setVisible(true);

        }
    }

    public void onBuyPack2() {

    }

    public ArrayList<Card> getDrawnCards() {
        return drawnCards;
    }

}
