package model;

import java.util.ArrayList;

public class Card {
    //Attributes
    private int value;
    private String rarity;
    private String cardName;
    private String[] categories;




    //Constructors
    public Card(int value, String cardName, String[] categories, String rarity) {
        this.value = value;
        this.cardName = cardName;
        this.categories = categories;
        this.rarity = rarity;
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

    public String getRarity() {
        return rarity;
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
