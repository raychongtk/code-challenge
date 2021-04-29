package priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author raychong
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((m1, m2) -> map.get(m2) - map.get(m1));
        for (Character c : map.keySet()) {
            priorityQueue.offer(c);
        }

        var builder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            char c = priorityQueue.poll();
            builder.append(String.valueOf(c).repeat(map.get(c)));
        }

        return builder.toString();
    }
}
