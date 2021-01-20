package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public abstract class Mission implements IMissionTask{


    private String name;
    private String description;
    protected ArrayList<IMissionTask> missionTasks;

    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public Mission(String name, String description, ArrayList<IMissionTask> missionTasks) {
        this.name = name;
        this.description = description;
        this.missionTasks = missionTasks;
    }

    //Methods


    //Getterbois
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int getReward(ArrayList<Card> collection) {
        int reward = 0;
        for(IMissionTask missionTask : missionTasks) {
            if(missionTask.isCompleteable(collection)) {
                reward += missionTask.getReward(collection);
            }
        }
        return reward;
    }

    @Override
    public boolean isCompleteable(ArrayList<Card> collection) {
        for(IMissionTask missionTask : missionTasks) {
            if(!missionTask.isCompleteable(collection)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<IMissionTask> getMissionTasks() {
        return new ArrayList<IMissionTask>(this.missionTasks);
    }

    //Setterbois



    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }
    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }


}


