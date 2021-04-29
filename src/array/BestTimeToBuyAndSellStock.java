package array;

/**
 * @author raychong
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    // 7,1,5,3,6,4
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i + 1] - min);
        }
        return max;
    }
}
