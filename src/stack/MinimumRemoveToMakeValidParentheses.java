package stack;

import java.util.Stack;

/**
 * @author raychong
 */
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        var builder = new StringBuilder();
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == ')' && stack.isEmpty()) continue;
            if (c == '(') stack.push(index);
            if (c == ')') stack.pop();
            builder.append(c);
            index++;
        }

        while (!stack.isEmpty()) {
            builder.deleteCharAt(stack.pop());
        }

        return builder.toString();
    }
}
