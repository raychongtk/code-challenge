package array;

/**
 * @author raychong
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[i];
                A[i] = A[index];
                A[index++] = temp;
            }
        }
        return A;
    }
}
