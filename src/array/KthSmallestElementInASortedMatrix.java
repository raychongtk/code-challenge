package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author raychong
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> ((int[]) a)[0]));

        for (int i = 0; i < matrix[0].length; i++) {
            priorityQueue.offer(new int[]{matrix[0][i], 0, i});
        }

        while (--k > 0) {
            int[] current = priorityQueue.poll();
            int row = current[1] + 1;
            int column = current[2];
            if (row == matrix.length) continue;
            priorityQueue.offer(new int[]{matrix[row][column], row, column});
        }

        return priorityQueue.poll()[0];
    }
}
