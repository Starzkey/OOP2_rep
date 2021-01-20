package model;

public enum Category {

    THIEF("Thief"),
    WARRIOR("Warrior"),
    DRAGON("Dragon"),
    MAGE("Mage"),
    HUMAN("Human"),
    DWARF("Dwarf"),
    PRIEST("Priest"),
    ARCHER("Archer"),
    MONSTER("Monster");


    private String text;

    Category(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text;
    }
}
