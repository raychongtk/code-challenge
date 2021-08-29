package dfs;

/**
 * @author raychong
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numberOfIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numberOfIsland++;
                }
            }
        }

        return numberOfIsland;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (outOfBound(row, column, grid.length, grid[0].length)) return;
        if (grid[row][column] != '1') return;

        grid[row][column] = '2';

        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }

    private boolean outOfBound(int row, int column, int actualRow, int actualColumn) {
        return row < 0 || row >= actualRow || column < 0 || column >= actualColumn;
    }
}
