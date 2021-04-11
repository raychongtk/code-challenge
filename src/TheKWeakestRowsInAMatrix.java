import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author raychong
 */
public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        Map<Integer, List<Integer>> table = new TreeMap<>();
        for (int i = 0; i < mat.length; i++) {
            int index = findRightMostIndex(mat[i]);
            List<Integer> values = table.getOrDefault(index, new ArrayList<>());
            values.add(i);
            table.put(index, values);
        }

        int i = 0;
        for (Map.Entry<Integer, List<Integer>> entry : table.entrySet()) {
            for (Integer data : entry.getValue()) {
                result[i++] = data;
                if (i == k) return result;
            }
        }

        return result;
    }

    private int findRightMostIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
                index = mid;
            }
        }

        return index;
    }
}
