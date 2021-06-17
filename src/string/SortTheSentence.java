package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author raychong
 */
public class SortTheSentence {
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
        System.out.println(sortSentenceV2("is2 sentence4 This1 a3"));
    }

    private static String sortSentence(String s) {
        String[] inputStringArr = s.split(" ");
        String[] sorted = new String[inputStringArr.length];

        for (String str : inputStringArr) {
            sorted[str.charAt(str.length() - 1) - '1'] = str.substring(0, str.length() - 1);
        }

        return String.join(" ", sorted);
    }

    private static String sortSentenceV2(String s) {
        Map<String, Stack<Integer>> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        var builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                Stack<Integer> stack = map.getOrDefault(builder.toString(), new Stack<>());
                stack.push(c - '1');
                map.put(builder.toString(), stack);
                list.add(builder.toString());
                builder.setLength(0);
            } else {
                builder.append(c);
            }
        }

        String[] result = new String[list.size()];
        for (String str : list) {
            result[map.get(str).pop()] = str;
        }

        return String.join(" ", result);
    }
}
