package string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author raychong
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
        System.out.println(backspaceCompareV2("y#fo##f", "y#f#o##f"));
    }

    public static boolean backspaceCompare(String S, String T) {
        Deque<Character> stack = new LinkedList<>();
        Deque<Character> stack1 = new LinkedList<>();

        for (char c : S.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        for (char c : T.toCharArray()) {
            if (c != '#') {
                stack1.push(c);
            } else if (!stack1.isEmpty()) {
                stack1.pop();
            }
        }
        System.out.println(stack);
        System.out.println(stack1);
        return stack.equals(stack1);
    }

    public static boolean backspaceCompareV2(String S, String T) {
        int sLength = S.length();
        int tLength = T.length();
        int maxLength = Math.max(sLength, tLength);

        var newS = new StringBuilder();
        var newT = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            if (i < sLength) {
                char c = S.charAt(i);
                if (c == '#') {
                    int length = newS.length();
                    if (length != 0) newS.deleteCharAt(length - 1);
                } else {
                    newS.append(c);
                }
            }

            if (i < tLength) {
                char c = T.charAt(i);
                if (c == '#') {
                    int length = newT.length();
                    if (length != 0) newT.deleteCharAt(length - 1);
                } else {
                    newT.append(c);
                }
            }
        }

        return newS.toString().equals(newT.toString());
    }
}
