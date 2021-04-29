package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author raychong
 */
public class CrawlerLogFolder {
    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
    }

    public static int minOperations(String[] logs) {
        Deque<String> deque = new ArrayDeque<>();
        for (String log : logs) {
            if ("./".equals(log)) continue;

            if (!"../".equals(log)) {
                deque.push(log);
            } else if (!deque.isEmpty()) {
                deque.pop();
            }
        }
        return deque.size();
    }
}
