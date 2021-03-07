import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        minDiff(list, root);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }

        return min;
    }

    private void minDiff(List<Integer> list, TreeNode node) {
        if (node == null) return;

        minDiff(list, node.left);
        list.add(node.val);
        minDiff(list, node.right);
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
