package linkedlist;

/**
 * @author raychong
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode newHead = new ListNode();
        ListNode node = newHead;
        node.val = head.val;
        head = head.next;

        int previous = node.val;
        while (head != null) {
            if (previous == head.val) {
                head = head.next;
                continue;
            }
            node.next = new ListNode();
            node = node.next;
            node.val = head.val;
            previous = head.val;
            head = head.next;
        }

        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
    }
}
