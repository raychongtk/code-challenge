import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), candidates, target, 0, 0);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> combination, int[] candidates, int target, int currentSum, int index) {
        if (currentSum > target) return;

        if (currentSum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(combinations, combination, candidates, target, currentSum + candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}
