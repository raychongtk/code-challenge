package dp;

/**
 * @author raychong
 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return dfs(m, n, 0, 0, memo);
    }

    private int dfs(int m, int n, int row, int column, int[][] memo) {
        if (row >= m || column >= n) {
            return 0;
        }
        if (row == m - 1 || column == n - 1) {
            return 1;
        }
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        int count = 0;
        count += dfs(m, n, row + 1, column, memo);
        count += dfs(m, n, row, column + 1, memo);
        memo[row][column] = count;
        return count;
    }

    public int dp(int m, int n) {
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    memo[0][j] = 1;
                } else if (j == 0) {
                    memo[i][0] = 1;
                } else {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                }
            }
        }

        return memo[m - 1][n - 1];
    }
}
