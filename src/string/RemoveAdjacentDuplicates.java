package string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author raychong
 */
public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println(removeAdjacentDuplicates("abccba")); // ""
        System.out.println(removeAdjacentDuplicates("foobar")); // "fbar"
        System.out.println(removeAdjacentDuplicates("abccbefggfe")); // "a"
    }

    private static String removeAdjacentDuplicates(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (stack.size() > 0 && stack.peekLast() == c) {
                stack.pollLast();
            } else {
                stack.addLast(c);
            }
        }

        var builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pollFirst());
        }
        return builder.toString();
    }
}
