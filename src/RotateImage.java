/**
 * @author raychong
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] data : matrix) {
            reverse(data);
        }
    }

    private void reverse(int[] data) {
        int start = 0;
        int end = data.length - 1;

        while (start < end) {
            int temp = data[start];
            data[start++] = data[end];
            data[end--] = temp;
        }
    }
}
