package slidingwindow;

/**
 * @author raychong
 */
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    // A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    // [1,1,1,0,0,1,1,1,1,1,1]
    // output: 6
    public static int longestOnes(int[] A, int K) {
        int start = 0;
        int max = 0;
        int zero = 0;

        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) zero++;
            if (zero > K && A[start++] == 0) zero--;
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
