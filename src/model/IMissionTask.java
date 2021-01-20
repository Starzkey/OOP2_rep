package model;

import java.util.ArrayList;

public interface IMissionTask {

    int getReward(ArrayList<Card> collection);
    boolean isCompleteable(ArrayList<Card> collection);
    MissionRequirement getMissionRequirement();
}

