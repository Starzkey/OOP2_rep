package view;

import model.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class MissionView extends JPanel implements PropertyChangeListener {

    private final Player player;
    private final Mission mission;

    private JLabel nameLabel;
    private JLabel rewardLabel;
    private JTextArea descriptionLabel;
    private JButton turnIn;

    private final ArrayList<JLabel> milestoneLabels;

    public MissionView(Mission mission, Player player) {

        this.mission = mission;
        this.player = player;
        this.milestoneLabels = new ArrayList<>();

        init();

        mission.addPropertyChangeListener(this);
        player.addPropertyChangeListener(this);
    }


    public void init() {
        nameLabel = new JLabel(mission.getName());
        rewardLabel = new JLabel("Reward: " + mission.getReward(player.getCollection()));
        descriptionLabel = new JTextArea(mission.getDescription());

        turnIn = new JButton("Turn In");

        add(nameLabel);
        add(rewardLabel);
        add(descriptionLabel);

        for (IMissionTask task : mission.getMissionTasks()) {
            JLabel label = new JLabel();
            milestoneLabels.add(label);
            add(label);
        }
        updateLabels(player.getCollection());

        add(turnIn);


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {


        switch (evt.getPropertyName()) {
            case "collection": updateLabels((ArrayList<Card>) evt.getNewValue());
            rewardLabel.setText("Reward: " + mission.getReward((ArrayList<Card>) evt.getNewValue()));
            break;
        }

    }


    //register-Methods

    public void registerOnTurnInListener(ActionListener listener) {
        turnIn.addActionListener(listener);
    }


    public void updateLabels(ArrayList<Card> collection) {

        int i = 0;

        for (JLabel label : milestoneLabels) {
            IMissionTask task = mission.getMissionTasks().get(i);
                int progress = 0;
                for (Card card : collection) {
                    for (Category category : card.getCategories()) {
                        if (category.equals(task.getMissionRequirement().getCategory())) {
                            progress++;
                        } //Progress shouldnt go over tasks amount, also must be staggered
                    }
                }
                label.setText("Progress: " + progress + " / " + task.getMissionRequirement().getAmount());
                i++;

        }
    }

}
