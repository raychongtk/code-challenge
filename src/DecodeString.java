import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author raychong
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    // Input: s = "3[a2[c]]"
    // Output: "accaccacc"
    public static String decodeString(String s) {
        Deque<String> stringStack = new ArrayDeque<>();
        Deque<Integer> digitStack = new ArrayDeque<>();
        int i = 0;
        stringStack.push("");
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int start = i;
                while (Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                digitStack.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (s.charAt(i) == '[') {
                stringStack.push("");
            } else if (s.charAt(i) == ']') {
                String str = stringStack.pop();
                int times = digitStack.pop();
                stringStack.push(stringStack.pop() + str.repeat(times));
            } else {
                stringStack.push(stringStack.pop() + s.charAt(i));
            }
            i++;
        }

        return stringStack.pop();
    }
}
