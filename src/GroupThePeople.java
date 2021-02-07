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
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>(500);
        int left = 0;
        int right = groupSizes.length - 1;

        for (int groupSize : groupSizes) {
            map.computeIfAbsent(groupSize, k -> new ArrayList<>());
        }

        while (left <= right) {
            List<Integer> leftGroup = map.get(groupSizes[left]);
            List<Integer> rightGroup = map.get(groupSizes[right]);

            leftGroup.add(left);
            map.put(groupSizes[left], leftGroup);

            if (left != right) {
                rightGroup.add(right);
                map.put(groupSizes[right], rightGroup);
            }

            left++;
            right--;
        }

        List<List<Integer>> groups = new ArrayList<>();
        map.forEach((key, value) -> {
            if (key == value.size()) {
                groups.add(value);
            } else {
                for (int i = 0; i < value.size(); i += key) {
                    groups.add(value.subList(i, i + key));
                }
            }
        });

        return groups;
    }
}
