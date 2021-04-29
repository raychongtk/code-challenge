package array;

/**
 * @author raychong
 */
public class RichestCustomerWealth {
    // [[1,2,3],[3,2,1]]
    // 6
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] account : accounts) {
            int sum = 0;
            for (int num : account) {
                sum += num;
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
