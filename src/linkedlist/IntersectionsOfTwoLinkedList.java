package linkedlist;

/**
 * @author raychong
 */
public class IntersectionsOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        boolean connectA = false;
        boolean connectB = false;

        while (dummyA != null && dummyB != null) {
            if (dummyA == dummyB) {
                return dummyA;
            }

            dummyA = dummyA.next;
            dummyB = dummyB.next;

            if (!connectB && dummyA == null) {
                dummyA = headB;
                connectB = true;
            }

            if (!connectA && dummyB == null) {
                dummyB = headA;
                connectA = true;
            }
        }

        return null;
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
