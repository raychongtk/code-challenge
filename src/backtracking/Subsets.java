package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subset(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }

    private void subset(List<List<Integer>> subsets, List<Integer> subList, int[] nums, int k) {
        List<Integer> newSubList = new ArrayList<>(subList);
        subsets.add(newSubList);
        for (int i = k; i < nums.length; i++) {
            newSubList.add(nums[i]);
            subset(subsets, newSubList, nums, i + 1);
            newSubList.remove(newSubList.size() - 1);
        }
    }
}
