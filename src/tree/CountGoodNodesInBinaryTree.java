package tree;

/**
 * @author raychong
 */
public class CountGoodNodesInBinaryTree {
    private int count;

    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return count;
    }

    private void traverse(TreeNode node, int parent) {
        if (node == null) return;
        int cur = node.val;
        if (cur >= parent) {
            count++;
        } else {
            cur = parent;
        }
        traverse(node.left, cur);
        traverse(node.right, cur);
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
