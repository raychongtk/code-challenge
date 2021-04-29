package string;

import java.util.Set;

/**
 * @author raychong
 */
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String s) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            boolean containLeftChar = set.contains(chars[left]);
            boolean containRightChar = set.contains(chars[right]);
            if (containLeftChar && containRightChar) {
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left++;
                right--;
                continue;
            }

            if (!containLeftChar) left++;
            if (!containRightChar) right--;
        }

        return String.valueOf(chars);
    }
}
