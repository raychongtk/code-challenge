package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author raychong
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        Deque<TreeNode> stack = new LinkedList<>();
        int sum = 0;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.val >= L && node.val <= R) sum += node.val;

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        return sum;
    }

    public int rangeSumBSTV2(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int left = rangeSumBST(root.left, L, R);
        int right = rangeSumBST(root.right, L, R);
        int sum = left + right;

        return root.val >= L && root.val <= R ? sum + root.val : sum;
    }

    private static class TreeNode {
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
