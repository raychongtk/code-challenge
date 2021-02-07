import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author raychong
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(("));
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (deque.size() == 0 || deque.pop() != '(') return false;
            } else if (c == ']') {
                if (deque.size() == 0 || deque.pop() != '[') return false;
            } else if (c == '}') {
                if (deque.size() == 0 || deque.pop() != '{') return false;
            } else {
                deque.push(c);
            }
        }

        return deque.size() == 0;
    }
}
