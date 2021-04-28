/**
 * @author raychong
 */
public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        return dfs(obstacleGrid, 0, 0, memo);
    }

    private int dfs(int[][] obstacleGrid, int row, int column, int[][] memo) {
        if (row >= obstacleGrid.length || column >= obstacleGrid[0].length) {
            return 0;
        }

        if (obstacleGrid[row][column] == 1) {
            return 0;
        }

        if (memo[row][column] != 0) {
            return memo[row][column];
        }

        if (row == obstacleGrid.length - 1 && column == obstacleGrid[0].length - 1) {
            return 1;
        }

        int count = 0;
        if (column != obstacleGrid[0].length - 1) {
            count += dfs(obstacleGrid, row, column + 1, memo);
        }
        if (row != obstacleGrid.length - 1) {
            count += dfs(obstacleGrid, row + 1, column, memo);
        }

        memo[row][column] = count;
        return count;
    }
}
