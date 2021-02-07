import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author raychong
 */
public class BuddyStrings {
    public static void main(String[] args) {
        System.out.println(buddyStrings("abc", "abc"));
    }

    // A = "ab", B = "ba" -> true
    // A = "ab", B = "ab" -> false
    public static boolean buddyStrings(String A, String B) {
        int n = A.length();
        int n1 = B.length();
        if (n == 0 && n1 == 0) return false;
        if (n != n1) return false;

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> deque2 = new ArrayDeque<>();
        int[] map = new int[26];
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                deque.push(A.charAt(i));
                deque2.add(B.charAt(i));
            }
            map[A.charAt(i) - 'a']++;
        }
        int max = Arrays.stream(map).max().getAsInt();

        if (deque.isEmpty() && max == 1) return false;
        if (deque.size() > 2) return false;
        return deque.toString().equals(deque2.toString());
    }
}
