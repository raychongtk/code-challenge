package dfs;

/**
 * @author raychong
 */
public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(grid, i, j, 0));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int row, int column, int current) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length
                || grid[row][column] == 0) {
            return current;
        }

        if (grid[row][column] == -1) return 0;

        int data = grid[row][column];
        current += data;

        grid[row][column] = -1;
        int left = dfs(grid, row - 1, column, current);
        int right = dfs(grid, row + 1, column, current);
        int top = dfs(grid, row, column - 1, current);
        int bottom = dfs(grid, row, column + 1, current);
        grid[row][column] = data;

        int horizontal = Math.max(left, right);
        int vertical = Math.max(top, bottom);

        return Math.max(horizontal, vertical);
    }
}
