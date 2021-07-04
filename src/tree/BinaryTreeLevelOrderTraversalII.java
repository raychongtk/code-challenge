package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        dfs(results, root, 0);

        int left = 0;
        int right = results.size() - 1;
        while (left < right) {
            List<Integer> result = results.get(left);
            results.set(left, results.get(right));
            results.set(right, result);
            left++;
            right--;
        }

        return results;
    }

    private void dfs(List<List<Integer>> results, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (results.size() == level) {
            List<Integer> result = new ArrayList<>();
            result.add(node.val);
            results.add(result);
        } else {
            List<Integer> result = results.get(level);
            result.add(node.val);
            results.set(level, result);
        }

        dfs(results, node.left, level + 1);
        dfs(results, node.right, level + 1);
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
