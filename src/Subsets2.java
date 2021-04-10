import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author raychong
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> subsets = new HashSet<>();
        Arrays.sort(nums);
        subset(subsets, new ArrayList<>(), nums, 0);
        return new ArrayList<>(subsets);
    }

    private void subset(Set<List<Integer>> subsets, List<Integer> subList, int[] nums, int k) {
        List<Integer> newSubList = new ArrayList<>(subList);
        subsets.add(newSubList);
        for (int i = k; i < nums.length; i++) {
            newSubList.add(nums[i]);
            subset(subsets, newSubList, nums, i + 1);
            newSubList.remove(newSubList.size() - 1);
        }
    }
}
