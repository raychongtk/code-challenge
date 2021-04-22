

/**
 * @author raychong
 */
public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int[][] memo = new int[n + 1][5];
        count(n, 0, memo);
        return memo[n][0];
    }

    private int count(int n, int index, int[][] memo) {
        if (n == 0) return 1;
        if (memo[n][index] > 0) return memo[n][index];

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (i >= index) {
                cnt += count(n - 1, i, memo);
            }
        }
        memo[n][index] = cnt;
        return cnt;
    }
}
