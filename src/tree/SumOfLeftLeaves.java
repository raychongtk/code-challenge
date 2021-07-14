package tree;

/**
 * @author raychong
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) return 0;

        if (isLeft && node.left == null && node.right == null) {
            return node.val;
        }

        return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
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
