package slidingwindow;

/**
 * @author raychong
 */
public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    // customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3 -> 16
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int grumpySum = 0;
        int withoutGrumpySum = 0;
        int max = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) withoutGrumpySum += customers[i];
            grumpySum += customers[i] * grumpy[i];

            if (i >= X) {
                grumpySum -= customers[i - X] * grumpy[i - X];
            }
            max = Math.max(max, grumpySum);
        }

        return withoutGrumpySum + max;
    }
}
