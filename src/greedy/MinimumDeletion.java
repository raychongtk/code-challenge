package greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumDeletion {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        int currentDeletion = 0;
        for (int value : map.values()) {
            while (value > 0 && set.contains(value)) {
                value--;
                currentDeletion++;
            }
            set.add(value);
        }

        return currentDeletion;
    }
}
