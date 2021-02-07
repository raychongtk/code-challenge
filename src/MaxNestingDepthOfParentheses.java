import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author raychong
 */
public class MaxNestingDepthOfParentheses {
    public static void main(String[] args) {
        System.out.println(maxDepth("1+(2*3)/(2-1)"));
    }

    public static int maxDepth(String s) {
        if (s.length() == 0) return 0;

        Deque<String> deque = new ArrayDeque<>();
        int max = 0;

        for (char c : s.toCharArray()) {
            if (c == ')') {
                max = Math.max(max, deque.size());
                deque.pop();
            } else if (c == '(') {
                deque.push("(");
            }
        }

        return max;
    }
}
