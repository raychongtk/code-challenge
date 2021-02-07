/**
 * @author raychong
 */
public class SubOddLengthSubArrays {
    public static void main(String[] args) {

    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;

        for (int windowSize = 1; windowSize <= arr.length; windowSize += 2) {
            int currentSum = 0;
            int leftWindow = 0;

            for (int rightWindow = 0; rightWindow < arr.length; rightWindow++) {
                currentSum += arr[rightWindow];
                if (rightWindow - leftWindow + 1 > windowSize) currentSum -= arr[leftWindow++];
                if (rightWindow - leftWindow + 1 == windowSize) sum += currentSum;
            }
        }

        return sum;
    }
}
