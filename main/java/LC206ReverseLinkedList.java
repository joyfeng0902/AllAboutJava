package main.java;

/**
 * Created by joyfeng on 11/21/2016.
 */
public class LC206ReverseLinkedList {
    // iterative
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // keep the prev node
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        head.next = null;
        next.next = head;

        return newHead;
    }
}
