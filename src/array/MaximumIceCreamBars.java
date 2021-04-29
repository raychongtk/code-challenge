package array;

import java.util.Arrays;

/**
 * @author raychong
 */
public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        for (int i = 0; i < costs.length; i++) {
            coins = coins - costs[i];
            if (coins < 0) {
                return i;
            }
        }

        return costs.length;
    }
}
