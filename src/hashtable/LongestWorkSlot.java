package hashtable;

/**
 * @author raychong
 */
public class LongestWorkSlot {
    public static void main(String[] args) {
        System.out.println(longestWorkSlot(new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}})); // b
        System.out.println(longestWorkSlot(new int[][]{{0, 2}, {1, 3}, {0, 7}})); // a
        System.out.println(longestWorkSlot(new int[][]{{0, 1}, {0, 3}, {4, 5}, {5, 6}, {4, 10}})); // e
    }

    public static char longestWorkSlot(int[][] leaveTimes) {
        int candidate = leaveTimes[0][0];
        int longest = leaveTimes[0][1];

        for (int i = 1; i < leaveTimes.length; i++) {
            int leaveTime = leaveTimes[i][1] - leaveTimes[i - 1][1];
            int currentCandidate = leaveTimes[i][0];

            if (longest < leaveTime) {
                longest = leaveTime;
                candidate = currentCandidate;
            }
        }

        return (char) (candidate + 'a');
    }
}
