package model;

public class MissionRequirement {

    private int amount;
    private Category category;

    public MissionRequirement(Category category, int amount) {
        this.amount = amount;
        this.category = category;

    }

    public int getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }


}
