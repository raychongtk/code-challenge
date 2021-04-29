package array;

import java.util.Arrays;

/**
 * @author raychong
 */
public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int maxIceCreamBar = 0;
        for (int i = 0; i < costs.length; i++) {
            coins = coins - costs[i];
            if (coins < 0) {
                return maxIceCreamBar;
            }
            maxIceCreamBar++;
        }

        return maxIceCreamBar;
    }
}
