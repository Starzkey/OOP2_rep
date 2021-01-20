package controller;

import model.Card;
import model.IMissionTask;
import model.Mission;
import model.Player;
import view.MissionView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MissionController {

    Player player;
    MissionView view;
    Mission mission;


    public MissionController(MissionView view, Player player, Mission mission) {

        this.player = player;
        this.view = view;
        this.mission = mission;

        view.registerOnTurnInListener(e -> onTurnIn());

    }


    public void onTurnIn() {

        System.out.println("hi");
        ArrayList<Card> collection = player.getCollection();


        for (IMissionTask task : mission.getMissionTasks()) {
            if (task.isCompleteable(collection)) {

                player.setBalance(player.getBalance() + task.getReward(collection));

                ArrayList<Card> cardsToRemove =
                        collection
                                .stream()
                                .filter((card) -> Arrays.asList(card.getCategories()).contains(task.getMissionRequirement().getCategory()))
                                .limit(task.getMissionRequirement().getAmount()).collect(Collectors.toCollection(ArrayList::new));

                for (Card card : cardsToRemove) {
                    collection = player.removeCard(card);
                }
            }
        }
    }


}
