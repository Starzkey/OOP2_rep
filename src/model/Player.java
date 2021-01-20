package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Player {
    private String name;
    private int balance;
    private ArrayList<Card> collection;
    private ArrayList<Mission> missions;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    //Constructors
    public Player(String name, int balance, ArrayList<Card> collection) {

        this.name = name;
        this.balance = balance;
        this.collection = collection;
        this.missions = new ArrayList<>();

    }

    //Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        changes.firePropertyChange("name", oldValue, this.name);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        int oldValue = this.balance;
        this.balance = balance;
        changes.firePropertyChange("balance", oldValue, this.balance);
    }

    public ArrayList<Card> getCollection() {
        return new ArrayList<>(collection);
    }

    public ArrayList<Mission> getMissions() {
        return new ArrayList<>(missions);
    }

    public void addCard(Card card) {
        ArrayList<Card> oldValue = new ArrayList<>(this.collection);
        collection.add(card);
        changes.firePropertyChange("collection", oldValue, new ArrayList<>(this.collection));
    }

    public ArrayList<Card> removeCard(Card card) {
        ArrayList<Card> oldValue = new ArrayList<>(this.collection);
        collection.remove(card);
        changes.firePropertyChange("collection", oldValue, new ArrayList<>(this.collection));
        return collection;
    }

    public void addMission(Mission mission) {
        ArrayList<Mission> oldValue = this.missions;
        missions.add(mission);
        changes.firePropertyChange("missions", oldValue, this.missions);
    }

    public void removeMission(Mission mission) {
        ArrayList<Mission> oldValue = this.missions;
        missions.remove(mission);
        changes.firePropertyChange("missions", oldValue, this.missions);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }

}
