package dfs;

/**
 * @author raychong
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int row, int column) {
        if (outOfBound(grid.length, grid[0].length, row, column)) return 0;
        if (grid[row][column] <= 0) return 0;

        grid[row][column] = -1;

        return 1 + dfs(grid, row + 1, column)
                + dfs(grid, row - 1, column)
                + dfs(grid, row, column + 1)
                + dfs(grid, row, column - 1);
    }

    private boolean outOfBound(int row, int column, int currentRow, int currentColumn) {
        return currentRow < 0 || currentRow >= row || currentColumn < 0 || currentColumn >= column;
    }
}
