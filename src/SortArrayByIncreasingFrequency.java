import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author raychong
 */
public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int i = 0;
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            for (int j = 0; j < pair.count; j++) {
                nums[i++] = pair.num;
            }
        }

        return nums;
    }

    public static class Pair implements Comparable<Pair> {
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }


        @Override
        public int compareTo(Pair o) {
            int compare = Integer.compare(this.count, o.count);
            return compare == 0 ? Integer.compare(this.num, o.num) * -1 : compare;
        }
    }
}
