package model;

import java.util.ArrayList;

public class MilestoneMission extends Mission implements IMissionTask {


    public MilestoneMission(String name, String description, ArrayList<IMissionTask> missionTasks) {
        super(name, description, missionTasks);

    }

    @Override
    public boolean isCompleteable(ArrayList<Card> collection) {
        for(IMissionTask milestone : missionTasks) {
            if(milestone.isCompleteable(collection)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public MissionRequirement getMissionRequirement() {
        return null; //Wird schon nicht benutzt werden...
    }

}
