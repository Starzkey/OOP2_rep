package model;

import java.util.ArrayList;

import static model.Category.HUMAN;

public class CardLibrary { //TODO write cards in english

    private ArrayList<Card> commonCards;
    private ArrayList<Card> uncommonCards;
    private ArrayList<Card> rareCards;
    private ArrayList<Card> allCards;

    public CardLibrary() {

        commonCards = new ArrayList<>();
        uncommonCards = new ArrayList<>();
        rareCards = new ArrayList<>();

        allCards = new ArrayList<>();

        allCards.addAll(commonCards);
        allCards.addAll(uncommonCards);
        allCards.addAll(rareCards);

        //loadCommonCards

        Card peasant = new Card(10, "Poor peasant", new Category[]{Category.WARRIOR, Category.HUMAN}, "common");
        commonCards.add(peasant);

        Card monk = new Card(10, "Monk", new Category[]{Category.PRIEST, Category.HUMAN,}, "common");
        commonCards.add(monk);

        Card peskyGoblin = new Card(10, "Pesky goblin", new Category[]{Category.THIEF, Category.MONSTER}, "common");
        commonCards.add(peskyGoblin);

        //loadUncommonCards

        Card axeswingerDwarf = new Card(20, "Dwarven axe swinger", new Category[]{Category.WARRIOR, Category.DWARF}, "uncommon");
        uncommonCards.add(axeswingerDwarf);

        Card knight = new Card(20, "Knight", new Category[]{Category.WARRIOR, Category.HUMAN}, "uncommon");
        uncommonCards.add(knight);

        Card minotaur = new Card(20, "Minotaur", new Category[]{Category.ARCHER, Category.MONSTER}, "uncommon");
        uncommonCards.add(minotaur);

        //loadRareCards

        Card mysticDragon = new Card(50, "Mystic dragon", new Category[]{Category.DRAGON, Category.MAGE}, "rare");
        rareCards.add(mysticDragon);

        Card ancientMage = new Card(50, "Ancient mage", new Category[]{Category.HUMAN, Category.MAGE}, "rare");
        rareCards.add(ancientMage);

        Card masterThief = new Card(50, "Master thief", new Category[]{Category.HUMAN, Category.THIEF}, "rare");
        rareCards.add(masterThief);

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

    public ArrayList<Card> getAllCards() {
        return allCards;
    }

    /* public static void loadCommonCards(ArrayList<Card> commonCards) {

        Card bauer = new Card(10,"Bauer", new Category[]{"Krieger", "Mensch"});
        commonCards.add(bauer);

    }

    public static void loadUncommonCards(ArrayList<Card> uncommonCards) {

        Card zwergAxtschwinger = new Card( 20,"Zwergen-Axtschwinger", new Category[]{"Krieger", "Zwerg"});
        uncommonCards.add(zwergAxtschwinger);

    }

    public static void loadRareCards(ArrayList<Card> rareCards) {

        Card mystischerDrache = new Card(50, "Mystischer Drache", new Category[]{"Drache", "Magier"});
        rareCards.add(mystischerDrache);

    } */
}
