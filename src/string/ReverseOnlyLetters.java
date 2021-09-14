package string;

/**
 * @author raychong
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            boolean isLeftChar = Character.isLetter(chars[start]);
            boolean isRightChar = Character.isLetter(chars[end]);
            if (isLeftChar && isRightChar) {
                char c = chars[start];
                chars[start++] = chars[end];
                chars[end--] = c;
            } else if (!isLeftChar) {
                start++;
            } else {
                end--;
            }
        }

        return String.valueOf(chars);
    }
}
