package utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static <T> List<List<T>> partition(List<T> source, int length) {
        int size = source.size();
        int partitionSize = (size - 1) / length;

        //create partitions
        List<List<T>> partitions = new ArrayList<>();
        for (int i = 0; i <= partitionSize; i++) {
            int startIndex = i * length;
            int endIndex = i == partitionSize ? size : (i + 1) * length;
            partitions.add(source.subList(startIndex, endIndex));
        }

        return partitions;
    }
}
