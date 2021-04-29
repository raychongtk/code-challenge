package array;

import java.util.Arrays;

/**
 * @author raychong
 */
public class XorQueriesOfSubArrays {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 8};
        int[][] queries = new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[arr.length];

        for (int j = 0; j < queries.length; j++) {
            int[] query = queries[j];
            if (query[0] == query[1]) {
                result[j] = arr[j];
                continue;
            }

            int xorResult = 0;
            for (int i = query[0]; i <= query[1]; i++) {
                xorResult ^= arr[i];
            }

            result[j] = xorResult;
        }

        return result;
    }
}
