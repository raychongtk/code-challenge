import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author raychong
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    // Input: nums = [-1,0,1,2,-1,-4]
    // Output: [[-1,-1,2],[-1,0,1]]
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>(10000);
        Set<List<Integer>> set = new HashSet<>(10000);
        int left = 0;
        int numLength = nums.length - 1;

        for (int num : nums) {
            Integer integer = map.getOrDefault(num, 0);
            map.put(num, integer + 1);
        }

        while (left < numLength) {
            int right = numLength;
            while (right > left) {
                int key = -(nums[left] + nums[right]);
                Integer target = map.get(key);
                if (target != null) {
                    if ((nums[left] == key || nums[right] == key) && target == 1) {
                        right--;
                        continue;
                    } else if (nums[left] == key && nums[right] == key && target <= 2) {
                        right--;
                        continue;
                    }

                    int min = Math.min(Math.min(nums[left], nums[right]), key);
                    int max = Math.max(Math.max(nums[left], nums[right]), key);
                    int mid = nums[left] + nums[right] + key - min - max;
                    set.add(Arrays.asList(min, mid, max));
                }
                right--;
            }
            left++;
        }

        return new ArrayList<>(set);
    }
}
