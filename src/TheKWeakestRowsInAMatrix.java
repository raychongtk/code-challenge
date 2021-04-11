import java.util.PriorityQueue;

/**
 * @author raychong
 */
public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            int index = findRightMostIndex(mat[i]);
            priorityQueue.offer(new Pair(i, index));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (priorityQueue.isEmpty()) break; // prevent NPE
            result[i] = priorityQueue.poll().rowIndex;
        }

        return result;
    }

    private int findRightMostIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
                index = mid;
            }
        }

        return index;
    }

    public static class Pair implements Comparable<Pair> {
        int rowIndex;
        int solider;

        public Pair(int rowIndex, int solider) {
            this.rowIndex = rowIndex;
            this.solider = solider;
        }

        @Override
        public int compareTo(Pair pair) {
            int compare = Integer.compare(this.solider, pair.solider);
            return compare == 0 ? Integer.compare(this.rowIndex, pair.rowIndex) : compare;
        }
    }
}
