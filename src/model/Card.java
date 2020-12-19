package model;

import java.util.ArrayList;

public class Card {
    //Attributes
    public int value;
    public String cardName;
    public String[] categories;



    //Constructors
    public Card(int value, String cardName, String[] categories) {
        this.value = value;
        this.cardName = cardName;
        this.categories = categories;
    }


    //Methods
    public String getCardName() {
        return cardName;
    }

    public int getValue() {
        return value;
    }

    public String[] getCategories() {
        return categories;
    }

    public static String toStringCategories(String[] categories) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i<categories.length; i++) {
            stringBuilder.append(categories[i]).append(", ");
        }

        return stringBuilder.toString();
    }

    /*  public void sellCard(Card soldCard, int playerBalance) { //Verkauft eine einzelne Karte
        playerBalance += soldCard.value;
        System.out.println("Die Karte " + cardName + " wurde für " + soldCard.value + " verkauft.");
        }*/


}
