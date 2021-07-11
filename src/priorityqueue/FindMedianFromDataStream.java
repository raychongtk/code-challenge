package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author raychong
 */
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        var finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

    private static class MedianFinder {
        private final PriorityQueue<Integer> minHeap;
        private final PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            double median;
            if (minHeap.size() > maxHeap.size()) {
                median = minHeap.peek();
            } else {
                median = (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
            return median;
        }
    }
}
