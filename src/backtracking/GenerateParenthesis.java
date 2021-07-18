package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, n, 0, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, int n, int left, int right, StringBuilder parenthesis) {
        if (right > left) return;
        if (n == parenthesis.length() / 2) {
            if (left == right) result.add(parenthesis.toString());
            return;
        }

        parenthesis.append("(");
        backtrack(result, n, left + 1, right, parenthesis);
        parenthesis.deleteCharAt(parenthesis.length() - 1);
        parenthesis.append(")");
        backtrack(result, n, left, right + 1, parenthesis);
        parenthesis.deleteCharAt(parenthesis.length() - 1);
    }
}
