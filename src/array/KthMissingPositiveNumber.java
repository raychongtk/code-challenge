package array;

/**
 * @author raychong
 */
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
    }

    /*
        Input: arr = [2,3,4,7,11], k = 5
        Output: 9
        Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...].
                     The 5th missing positive integer is 9.
     */
    public static int findKthPositive(int[] arr, int k) {
        int[] map = new int[2001];
        for (int num : arr) {
            map[num]++;
        }

        int index = 0;
        for (int i = 1; i < 2001; i++) {
            if (map[i] == 0) index++;
            if (index == k) return i;
        }

        return -1;
    }
}
