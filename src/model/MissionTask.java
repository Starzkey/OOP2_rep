package model;

import java.util.ArrayList;

public class MissionTask implements IMissionTask {

    private int reward;
    private MissionRequirement missionRequirement;

    public MissionTask(int reward, MissionRequirement missionRequirement) {
        this.missionRequirement = missionRequirement;
        this.reward = reward;

    }

    @Override
    public int getReward(ArrayList<Card> collection) {
        return reward;
    }

    @Override
    public boolean isCompleteable(ArrayList<Card> collection) {

        int amount = 0;

        for(Card card : collection) {
            for(Category category : card.getCategories()) {
                if(category.equals(missionRequirement.getCategory())) {
                    amount++;
                }
            }
        }
        if(amount >= missionRequirement.getAmount()) {
            return true;
        }
        return false;
    }

    public MissionRequirement getMissionRequirement() {
        return missionRequirement;
    }
}
