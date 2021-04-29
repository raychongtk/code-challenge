package twopointer;

/**
 * @author raychong
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 2, 1}));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int min = Math.min(height[left], height[right]);
            int distance = right - left;
            max = Math.max(max, min * distance);
            if (min == height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
