package model;

import java.util.ArrayList;

public class CardLibrary {

    private ArrayList<Card> commonCards;
    private ArrayList<Card> uncommonCards;
    private ArrayList<Card> rareCards;

    public CardLibrary() {

        commonCards = new ArrayList<>();
        uncommonCards = new ArrayList<>();
        rareCards = new ArrayList<>();

        //loadCommonCards

        Card bauer = new Card(10,"Bauer", new String[]{"Krieger", "Mensch"});
        commonCards.add(bauer);

        Card moench = new Card(10,"Moench", new String[]{"Priester", "Mensch"});
        commonCards.add(moench);

        Card fieserGoblin = new Card(10,"fieser Goblin", new String[]{"Dieb", "Monster"});
        commonCards.add(fieserGoblin);

        //loadUncommonCards

        Card zwergAxtschwinger = new Card( 20,"Zwergen-Axtschwinger", new String[]{"Krieger", "Zwerg"});
        uncommonCards.add(zwergAxtschwinger);

        Card ritter = new Card( 20,"Ritter", new String[]{"Krieger", "Mensch"});
        uncommonCards.add(ritter);

        Card minotaur = new Card( 20,"Minotaur", new String[]{"Bogenschuetze", "Monster"});
        uncommonCards.add(minotaur);

        //loadRareCards

        Card mystischerDrache = new Card(50, "Mystischer Drache", new String[]{"Drache", "Magier"});
        rareCards.add(mystischerDrache);

        Card uralterMagier = new Card(50, "Mystischer Drache", new String[]{"Mensch", "Magier"});
        rareCards.add(uralterMagier);

        Card meisterdieb = new Card(50, "Meisterdieb", new String[]{"Mensch", "Dieb"});
        rareCards.add(meisterdieb);

    }

    public ArrayList<Card> getCommonCards() {
        return commonCards;
    }

    public ArrayList<Card> getUncommonCards() {
        return uncommonCards;
    }

    public ArrayList<Card> getRareCards() {
        return rareCards;
    }

    /* public static void loadCommonCards(ArrayList<Card> commonCards) {

        Card bauer = new Card(10,"Bauer", new String[]{"Krieger", "Mensch"});
        commonCards.add(bauer);

    }

    public static void loadUncommonCards(ArrayList<Card> uncommonCards) {

        Card zwergAxtschwinger = new Card( 20,"Zwergen-Axtschwinger", new String[]{"Krieger", "Zwerg"});
        uncommonCards.add(zwergAxtschwinger);

    }

    public static void loadRareCards(ArrayList<Card> rareCards) {

        Card mystischerDrache = new Card(50, "Mystischer Drache", new String[]{"Drache", "Magier"});
        rareCards.add(mystischerDrache);

    } */
}
