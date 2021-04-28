/**
 * @author raychong
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        floodFill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void floodFill(int[][] image, int row, int column, int newColor, int startingColor) {
        if (newColor == startingColor) {
            return;
        }

        if (outOfBound(image.length, image[0].length, row, column)) {
            return;
        }

        if (image[row][column] != startingColor) {
            return;
        }

        image[row][column] = newColor;

        floodFill(image, row - 1, column, newColor, startingColor);
        floodFill(image, row + 1, column, newColor, startingColor);
        floodFill(image, row, column - 1, newColor, startingColor);
        floodFill(image, row, column + 1, newColor, startingColor);
    }

    private boolean outOfBound(int rowLength, int columnLength, int row, int column) {
        return row < 0 || row >= rowLength || column < 0 || column >= columnLength;
    }
}
