package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Card {
    //Attributes
    private int value;
    private String rarity;
    private String name;
    private Category[] categories; //TODO make this enum
    private boolean selected;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    //Constructors
    public Card(int value, String name, Category[] categories, String rarity) {
        this.value = value;
        this.name = name;
        this.categories = categories;
        this.rarity = rarity;
        this.selected = false;

    }

    public static String toStringCategories(Category[] categories) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < categories.length; i++) {
            stringBuilder.append(categories[i].toString()).append(", "); //Works?!
        }
        return stringBuilder.toString();
    }

    //Methods
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public Category[] getCategories() {
        return categories;
    }

    public String getRarity() {
        return rarity;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        boolean oldValue = this.selected;
        this.selected = selected;
        changes.firePropertyChange("selected", oldValue, this.selected);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }

    /*  public void sellCard(Card soldCard, int balance) { //Verkauft eine einzelne Karte
        balance += soldCard.value;
        System.out.println("Die Karte " + name + " wurde für " + soldCard.value + " verkauft.");
        }*/

}
