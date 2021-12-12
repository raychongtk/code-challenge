package sort;

import java.util.Arrays;

/**
 * @author raychong
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int ans = 1;
        int previous = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (previous < pairs[i][0]) {
                ans++;
                previous = pairs[i][1];
            }
        }
        return ans;
    }
}
