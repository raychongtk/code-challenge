package string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author raychong
 */
public class RemoveAllAdjacentDuplicatesInStringII {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }

    //Input: s = "deeedbbcccbdaa", k = 3
    //Output: "aa"
    //Explanation:
    //First delete "eee" and "ccc", get "ddbbbdaa"
    //Then delete "bbb", get "dddaa"
    //Finally delete "ddd", get "aa"
    public static String removeDuplicates(String s, int k) {
        List<Pair> compressed = compress(s);
        while (true) {
            Iterator<Pair> iterator = compressed.iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                int remainder = pair.count % k;
                if (remainder == 0) {
                    iterator.remove();
                } else {
                    pair.count = remainder;
                }
            }
            MergedList mergedList = merge(compressed, k);
            compressed = mergedList.mergedList;
            if (mergedList.shouldStop) break;
        }

        var builder = new StringBuilder();
        for (Pair pair : compressed) {
            builder.append(String.valueOf(pair.letter).repeat(pair.count));
        }
        return builder.toString();
    }

    private static MergedList merge(List<Pair> pairs, int k) {
        List<Pair> mergedPair = new ArrayList<>();
        mergedPair.add(pairs.get(0));
        char prev = pairs.get(0).letter;
        int index = 0;
        boolean shouldStop = true;
        for (int i = 1; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);
            if (pair.letter == prev) {
                mergedPair.get(index).count += pair.count;
                if (mergedPair.get(index).count >= k) shouldStop = false;
            } else {
                prev = pair.letter;
                mergedPair.add(pair);
                index++;
            }
        }
        return new MergedList(mergedPair, shouldStop);
    }

    private static List<Pair> compress(String s) {
        List<Pair> compressed = new ArrayList<>();
        int count = 1;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prev) {
                count++;
            } else {
                compressed.add(new Pair(prev, count));
                prev = c;
                count = 1;
            }
        }
        compressed.add(new Pair(prev, count));
        return compressed;
    }

    public static class MergedList {
        List<Pair> mergedList;
        boolean shouldStop;

        public MergedList(List<Pair> mergedList, boolean shouldStop) {
            this.mergedList = mergedList;
            this.shouldStop = shouldStop;
        }
    }

    public static class Pair {
        char letter;
        int count;

        public Pair(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }
}
