package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author raychong
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int mergedSize = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] previousInterval = intervals[i - 1];
            int[] currentInterval = intervals[i];

            if (previousInterval[1] >= currentInterval[0]) {
                intervals[i][0] = previousInterval[0];
                intervals[i][1] = Math.max(previousInterval[1], currentInterval[1]);
                intervals[i - 1][0] = -1;
                intervals[i - 1][1] = -1;
                mergedSize++;
            }
        }

        int[][] mergedIntervals = new int[intervals.length - mergedSize][2];
        int index = 0;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start == -1 && end == -1) continue;
            mergedIntervals[index][0] = start;
            mergedIntervals[index++][1] = end;
        }

        return mergedIntervals;
    }
}
