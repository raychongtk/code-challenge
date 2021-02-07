import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> partitions = new ArrayList<>();
        int[] map = new int[26];

        char[] chars = S.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            map[chars[i] - 'a'] = i;
        }

        int partitionMax = 0;
        int previousIndex = 0;
        for (int i = 0; i < n; i++) {
            partitionMax = Math.max(partitionMax, map[S.charAt(i) - 'a']);
            if (partitionMax == i) {
                partitions.add(i - previousIndex + 1);
                previousIndex = i + 1;
            }
        }

        return partitions;
    }
}
