import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), n, k, 1);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> combination, int n, int k, int index) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i <= n; i++) {
            combination.add(i);
            backtrack(combinations, combination, n, k, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
