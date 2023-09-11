package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author raychong
 */
public class GroupThePeople {
    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
    }

    /*
        Input: groupSizes = [3,3,3,3,3,1,3]
        Output: [[5],[0,1,2],[3,4,6]]
     */
    private static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);

            if (list.size() == groupSizes[i]) {
                result.add(list);
                map.remove(groupSizes[i]);
            }
        }

        return result;
    }
}
