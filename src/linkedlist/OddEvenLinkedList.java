package linkedlist;

/**
 * @author raychong
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode root = head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddResult = odd;
        ListNode evenResult = even;

        int index = 1;
        while (root != null) {
            if (index % 2 == 0) {
                even.next = new ListNode(root.val);
                even = even.next;
            } else {
                odd.next = new ListNode(root.val);
                odd = odd.next;
            }
            root = root.next;
            index++;
        }

        odd.next = evenResult.next;
        return oddResult.next;
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
