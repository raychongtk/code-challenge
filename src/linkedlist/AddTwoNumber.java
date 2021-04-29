package linkedlist;

import java.math.BigInteger;

/**
 * @author raychong
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger firstNumber = reverseNumber(getNumber(l1));
        BigInteger secondNumber = reverseNumber(getNumber(l2));
        BigInteger answer = firstNumber.add(secondNumber);
        return buildNode(answer);
    }

    public String getNumber(ListNode node) {
        BigInteger number = BigInteger.ONE;

        while (node != null) {
            number = number.multiply(BigInteger.TEN).add(BigInteger.valueOf(node.val));
            node = node.next;
        }

        return number.toString().substring(1);
    }

    public BigInteger reverseNumber(String number) {
        return new BigInteger(new StringBuilder(number).reverse().toString());
    }

    public ListNode buildNode(BigInteger number) {
        ListNode head = new ListNode();
        ListNode node = head;
        while (number.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = number.mod(BigInteger.TEN);
            number = number.divide(BigInteger.TEN);
            node.val = remainder.intValue();
            if (number.compareTo(BigInteger.ZERO) == 0) break;
            node.next = new ListNode();
            node = node.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
    }
}
