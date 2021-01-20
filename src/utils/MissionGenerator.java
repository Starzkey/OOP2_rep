package utils;

import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MissionGenerator {


    public static Mission generateRandomMission() {
        ArrayList<IMissionTask> milestones = new ArrayList<>();
        Category randCategory = getRandomCategory();
        for (int i = 0; i < getRandomRange(1, 4); i++) {
            MissionRequirement req = new MissionRequirement(randCategory, getRandomRange(1, 3));
            MissionTask milestone = new MissionTask(getRandomRange(50, 100) * (i +1), req);
            milestones.add(milestone);
        }

        return new MilestoneMission("Collect all " + randCategory.toString(), "Find as many " + randCategory.toString() + " as you can!", milestones);

    }

    public static int getRandomRange(int start, int end) {
        return (int) (Math.random() * ((end - start) + 1)) + start;
    }

    public static Category getRandomCategory() {
        return Category.values()[(getRandomRange(0, Category.values().length - 1)) ];
    }
}
