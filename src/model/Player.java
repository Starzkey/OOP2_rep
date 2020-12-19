package model;
import model.Card;

import java.util.ArrayList;

public class Player {
    //Attributes
    public String playerName;
    public int playerBalance;
    public ArrayList<Card> playerCollection;

    //Constructors
    public Player(String playerName, int playerBalance, ArrayList<Card> playerCollection) {

        playerCollection = new ArrayList<>();

        this.playerName = playerName;
        this.playerBalance = playerBalance;
        this.playerCollection = playerCollection;


    }

    //Methods
    public int getPlayerBalance() {
        return playerBalance;
    }

    //Diese Methode braucht Abruf von playerCollection von Player, da nur Karten aus playerCollection verkauft werden können.
    /*public void sellCard(Card soldCard, Player player) { //Verkauft eine einzelne Karte
        soldCard.amount -= 1;
        player.playerBalance += soldCard.value;
        System.out.println("Die Karte " + soldCard.cardName + " wurde für " + soldCard.value + " verkauft.");
    }

     */
}