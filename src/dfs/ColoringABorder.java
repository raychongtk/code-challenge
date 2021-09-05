package dfs;

/**
 * @author raychong
 */
public class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int oldColor = grid[row][col];
        dfs(grid, row, col, color, oldColor, visited);
        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int color, int oldColor, boolean[][] visited) {
        if (outOfBound(row, col, grid.length - 1, grid[0].length - 1) || visited[row][col] || grid[row][col] != oldColor) {
            return;
        }

        boolean border = isBorder(row, col, grid.length - 1, grid[0].length - 1, oldColor, grid);

        visited[row][col] = true;
        dfs(grid, row + 1, col, color, oldColor, visited);
        dfs(grid, row - 1, col, color, oldColor, visited);
        dfs(grid, row, col + 1, color, oldColor, visited);
        dfs(grid, row, col - 1, color, oldColor, visited);

        if (border) grid[row][col] = color;
    }

    private boolean isBorder(int row, int column, int actualRow, int actualColumn, int oldColor, int[][] grid) {
        return row == 0 || column == 0 || row == actualRow || column == actualColumn
                || grid[row + 1][column] != oldColor || grid[row - 1][column] != oldColor
                || grid[row][column + 1] != oldColor || grid[row][column - 1] != oldColor;
    }

    private boolean outOfBound(int row, int column, int actualRow, int actualColumn) {
        return row < 0 || column < 0 || row > actualRow || column > actualColumn;
    }
}
