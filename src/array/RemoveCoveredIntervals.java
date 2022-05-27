package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author raychong
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] x) -> x[0]).thenComparing(Comparator.comparingInt((int[] x) -> x[1]).reversed()));
        int count = 1;
        int x = intervals[0][0];
        int y = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > x && intervals[i][1] > y) {
                x = intervals[i][0];
                y = intervals[i][1];
                count++;
            }
        }
        return count;
    }
}
