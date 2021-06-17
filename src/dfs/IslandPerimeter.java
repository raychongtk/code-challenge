package dfs;

/**
 * @author raychong
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int row, int column) {
        if (outBound(grid.length, grid[0].length, row, column)) {
            return 1;
        }

        if (grid[row][column] == 0) {
            return 1;
        }

        if (grid[row][column] == 2) {
            return 0;
        }

        grid[row][column] = 2;

        return dfs(grid, row + 1, column)
                + dfs(grid, row, column + 1)
                + dfs(grid, row - 1, column)
                + dfs(grid, row, column - 1);
    }

    private boolean outBound(int rowLength, int columnLength, int row, int column) {
        return row < 0 || row >= rowLength || column < 0 || column >= columnLength;
    }
}
