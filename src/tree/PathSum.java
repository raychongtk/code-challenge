package tree;

/**
 * @author raychong
 */
public class PathSum {
    private boolean found = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        dfs(root, targetSum, root.val);
        return found;
    }

    private void dfs(TreeNode node, int targetSum, int currentSum) {
        if (node == null) return;
        if (currentSum == targetSum && node.left == null && node.right == null) {
            found = true;
            return;
        }
        if (currentSum > targetSum && node.left == null && node.right == null) {
            return;
        }

        if (node.left != null) {
            dfs(node.left, targetSum, currentSum + node.left.val);
        }
        if (node.right != null) {
            dfs(node.right, targetSum, currentSum + node.right.val);
        }
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
