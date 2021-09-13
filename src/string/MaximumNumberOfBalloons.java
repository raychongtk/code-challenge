package string;

/**
 * @author raychong
 */
public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        char[] chars = text.toCharArray();
        char[] balloons = "balloon".toCharArray();
        int totalCount = 0;

        for (char c : chars) {
            count[c - 'a']++;
        }

        while (true) {
            for (char b : balloons) {
                count[b - 'a']--;
                if (count[b - 'a'] < 0) return totalCount;
            }
            totalCount++;
        }
    }
}
