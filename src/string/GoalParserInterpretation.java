package string;

/**
 * @author raychong
 */
public class GoalParserInterpretation {
    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
    }

    // G()(al)
    // Goal
    public static String interpret(String command) {
        var builder = new StringBuilder();
        int n = command.length();
        for (int i = 0; i < n; i++) {
            if (command.charAt(i) == 'G') builder.append('G');
            if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                builder.append('o');
                i++;
            }
            if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a') {
                builder.append("al");
                i += 3;
            }
        }
        return builder.toString();
    }
}
