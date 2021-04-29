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
}
