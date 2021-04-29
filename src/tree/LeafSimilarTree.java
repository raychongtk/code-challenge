package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author raychong
 */
public class LeafSimilarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        leaf(list1, root1);
        leaf(list2, root2);

        int hash1 = Objects.hash(list1);
        int hash2 = Objects.hash(list2);
        return hash1 == hash2;
    }

    private int leaf(List<Integer> list, TreeNode node) {
        if (node == null) return -1;

        int left = leaf(list, node.left);
        int right = leaf(list, node.right);

        if (left == -1 && right == -1) list.add(node.val);

        return 0;
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
