package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author raychong
 */
public class FIndLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        result.add(root.val);
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                if (queue.peek() != null) {
                    result.add(max);
                    queue.add(null);
                }
                max = Integer.MIN_VALUE;
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                    max = Math.max(max, node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    max = Math.max(max, node.right.val);
                }
            }
        }

        return result;
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
