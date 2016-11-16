package main.java;

/**
 * Created by joyfeng on 11/4/2016.
 */
public class LC2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), head = dummy;  // see how dummy and head work together
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i1 = (l1 == null) ? 0 : l1.val;
            int i2 = (l2 == null) ? 0 : l2.val;

            int sum = i1 + i2 + carry;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            head = head.next;

        }

        if (carry == 1) {
            head.next = new ListNode(1);
        }

        return dummy.next;
    }
}
