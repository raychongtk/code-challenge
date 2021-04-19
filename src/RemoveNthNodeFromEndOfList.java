import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode dummy = new ListNode(0, head);
        ListNode root = dummy;
        while (root != null) {
            nodes.add(root);
            root = root.next;
        }

        if (n == 1 && nodes.size() - 1 == 1) return null;
        if (n == nodes.size() - 1) {
            dummy = dummy.next;
        } else {
            nodes.get(nodes.size() - n - 1).next = nodes.get(nodes.size() - n).next;
        }

        return dummy.next;
    }

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
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
