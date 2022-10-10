package greedy;

public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";

        char[] chars = palindrome.toCharArray();
        int size = chars.length / 2;

        for (int i = 0; i < size; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }

        }
        chars[chars.length - 1] = 'b';
        return String.valueOf(chars);
    }
}
