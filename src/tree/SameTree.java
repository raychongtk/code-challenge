package tree;

import java.util.Objects;
import java.util.Stack;

/**
 * @author raychong
 */
public class SameTree {
    public boolean isSameTreeV3(TreeNode p, TreeNode q) {
        Stack<TreeNode> tree1 = new Stack<>();
        Stack<TreeNode> tree2 = new Stack<>();
        tree1.push(p);
        tree2.push(q);

        while (!tree1.isEmpty() && !tree2.isEmpty()) {
            TreeNode node1 = tree1.pop();
            TreeNode node2 = tree2.pop();

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;

            tree1.push(node1.left);
            tree2.push(node2.left);
            tree1.push(node1.right);
            tree2.push(node2.right);
        }

        return tree1.size() == tree2.size();
    }

    public boolean isSameTreeV2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTreeV2(p.left, q.left) && isSameTreeV2(p.right, q.right);
    }

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
