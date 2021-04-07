import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        permute(permutations, nums, 0);

        return permutations;
    }

    private void permute(List<List<Integer>> permutations, int[] nums, int k) {
        if (k > nums.length) {
            List<Integer> combination = new ArrayList<>();
            for (int number : nums) {
                combination.add(number);
            }
            permutations.add(combination);
            return;
        }

        permute(permutations, nums, k + 1);
        for (int i = k + 1; i < nums.length; i++) {
            swap(nums, k, i);
            permute(permutations, nums, k + 1);
            swap(nums, k, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
