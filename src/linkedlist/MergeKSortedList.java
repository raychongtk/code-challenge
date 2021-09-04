package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author raychong
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode root = new ListNode();
        ListNode dummy = root;
        for (ListNode list : lists) {
            if (list == null) continue;
            priorityQueue.offer(list);
        }

        while (!priorityQueue.isEmpty()) {
            ListNode current = priorityQueue.poll();

            dummy.next = new ListNode(current.val);
            dummy = dummy.next;
            current = current.next;
            if (current != null) {
                priorityQueue.offer(current);
            }
        }

        return root.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
