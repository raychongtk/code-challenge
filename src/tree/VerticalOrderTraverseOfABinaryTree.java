package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author raychong
 */
public class VerticalOrderTraverseOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> table = new TreeMap<>();
        List<List<Integer>> columns = new ArrayList<>();
        traverse(table, root, 0, 0);
        for (Map<Integer, PriorityQueue<Integer>> rows : table.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> priorityQueue : rows.values()) {
                while (!priorityQueue.isEmpty()) {
                    column.add(priorityQueue.poll());
                }
            }
            columns.add(column);
        }
        return columns;
    }

    private void traverse(Map<Integer, Map<Integer, PriorityQueue<Integer>>> table, TreeNode node, int column, int row) {
        if (node == null) return;

        traverse(table, node.left, column - 1, row + 1);
        table.computeIfAbsent(column, x -> new TreeMap<>()).computeIfAbsent(row, x -> new PriorityQueue<>()).add(node.val);
        traverse(table, node.right, column + 1, row + 1);
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
