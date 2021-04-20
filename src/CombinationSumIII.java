import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), k, n, 1, 0);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> combination, int k, int n, int index, int currentSum) {
        if (currentSum > n) return;
        if (combination.size() == k && currentSum == n) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i <= 9; i++) {
            combination.add(i);
            backtrack(combinations, combination, k, n, i + 1, currentSum + i);
            combination.remove(combination.size() - 1);
        }
    }
}
