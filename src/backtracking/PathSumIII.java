package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, result, new ArrayList<>(), 0, targetSum);
        return result;
    }

    private void backtrack(TreeNode root, List<List<Integer>> result, List<Integer> pathSum, int currentSum, int targetSum) {
        if (root == null) {
            return;
        }

        currentSum += root.val;
        if (root.left == null && root.right == null && currentSum == targetSum) {
            List<Integer> newPath = new ArrayList<>(pathSum);
            newPath.add(root.val);
            result.add(newPath);
            return;
        }

        pathSum.add(root.val);
        backtrack(root.left, result, pathSum, currentSum, targetSum);
        backtrack(root.right, result, pathSum, currentSum, targetSum);
        pathSum.remove(pathSum.size() - 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
