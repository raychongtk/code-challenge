package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class ContainDuplicate2 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer lastIndex = map.get(nums[i]);
            if (lastIndex != null && i - lastIndex <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
