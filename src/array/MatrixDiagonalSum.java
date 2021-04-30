package array;

/**
 * @author raychong
 */
public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += mat[i][i];
            sum += mat[i][n - i - 1];
        }

        if (m % 2 == 1) {
            sum -= mat[m / 2][n / 2];
        }

        return sum;
    }
}
