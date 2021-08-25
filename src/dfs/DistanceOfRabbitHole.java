package dfs;

import java.util.Arrays;

/**
 * @author raychong
 */
public class DistanceOfRabbitHole {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {-1, 0, 1,},
                {1, 1, -1,},
                {1, 1, 0,},
        };

        int[][] grid2 = new int[][]{
                {1, 1, 1,},
                {1, -1, -1,},
                {1, 1, 0,},
        };

        System.out.println(Arrays.deepToString(rabbitHole(grid)));
        System.out.println(Arrays.deepToString(rabbitHole(grid2)));
    }

    private static int[][] rabbitHole(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int distance = dfs(grid, i, j, 0);
                    grid[i][j] = distance;
                }
            }
        }
        return grid;
    }

    private static int dfs(int[][] grid, int row, int column, int distance) {
        if (outOfBound(row, column, grid.length, grid[0].length) || grid[row][column] == -1) {
            return Integer.MAX_VALUE;
        }

        if (grid[row][column] == 0) {
            return distance;
        }

        int current = grid[row][column];
        distance += 1;
        grid[row][column] = -1;
        int top = dfs(grid, row + 1, column, distance);
        int bottom = dfs(grid, row - 1, column, distance);
        int right = dfs(grid, row, column + 1, distance);
        int left = dfs(grid, row, column - 1, distance);
        grid[row][column] = current;

        int horizontal = Math.min(left, right);
        int vertical = Math.min(top, bottom);

        return Math.min(horizontal, vertical);
    }

    private static boolean outOfBound(int row, int column, int rowBound, int columnBound) {
        return row < 0 || row >= rowBound || column < 0 || column >= columnBound;
    }
}
