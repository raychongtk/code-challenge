package tree;

import java.util.Objects;

/**
 * @author raychong
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        var builder1 = new StringBuilder(256);
        var builder2 = new StringBuilder(256);

        traverse(builder1, p);
        traverse(builder2, q);

        return Objects.hash(builder1.toString()) == Objects.hash(builder2.toString());
    }

    private void traverse(StringBuilder builder, TreeNode node) {
        if (node == null) {
            builder.append(-1);
            return;
        }
        builder.append(node.val);
        traverse(builder, node.left);
        traverse(builder, node.right);
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
