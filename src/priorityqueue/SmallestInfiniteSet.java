package priorityqueue;

import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    private final PriorityQueue<Integer> priorityQueue;
    private int min;

    public SmallestInfiniteSet() {
        priorityQueue = new PriorityQueue<>();
        min = 1;
    }

    public int popSmallest() {
        if (!priorityQueue.isEmpty()) return priorityQueue.poll();
        min++;
        return min - 1;
    }

    public void addBack(int num) {
        if (min > num && !priorityQueue.contains(num)) {
            priorityQueue.add(num);
        }
    }
}
