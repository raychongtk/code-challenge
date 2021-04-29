package string;

import java.util.Arrays;

/**
 * @author raychong
 */
public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }

    // Input: s = "loveleetcode", c = "e"
    // Output: [3,2,1,0,1,0,0,1,2,2,1,0]
    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] map = new int[n];

        int targetPosition = -1;
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (chars[i] == c) targetPosition = i;
            if (targetPosition > -1) {
                map[i] = i - targetPosition;
            } else {
                map[i] = Integer.MAX_VALUE;
            }
        }

        targetPosition = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == c) targetPosition = i;

            map[i] = Math.min(map[i], Math.abs(targetPosition - i));
        }

        return map;
    }
}
