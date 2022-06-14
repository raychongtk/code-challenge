package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class LongestWorkSlot {
    public static void main(String[] args) {
        System.out.println(longestWorkSlot(new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}}));
        System.out.println(longestWorkSlot(new int[][]{{0, 2}, {1, 3}, {0, 7}}));
        System.out.println(longestWorkSlot(new int[][]{{0, 1}, {0, 3}, {4, 5}, {5, 6}, {4, 10}}));
    }

    public static char longestWorkSlot(int[][] leaveTimes) {
        Map<Integer, Integer> employeeLeaveTimes = new HashMap<>();
        employeeLeaveTimes.put(leaveTimes[0][0], leaveTimes[0][1]);

        int max = 0;
        int candidate = 0;

        for (int i = 1; i < leaveTimes.length; i++) {
            int leaveTime = leaveTimes[i][1] - leaveTimes[i - 1][1];
            int currentCandidate = leaveTimes[i][0];

            if (employeeLeaveTimes.containsKey(currentCandidate)) {
                employeeLeaveTimes.put(currentCandidate, Math.max(employeeLeaveTimes.get(currentCandidate), leaveTime));
            } else {
                employeeLeaveTimes.put(currentCandidate, leaveTime);
            }

            int updatedLeaveTime = employeeLeaveTimes.get(currentCandidate);
            if (max < updatedLeaveTime) {
                max = updatedLeaveTime;
                candidate = currentCandidate;
            }
        }

        return (char) (candidate + 'a');
    }
}
