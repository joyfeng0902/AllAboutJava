package main.java;

/**
 * Created by joyfeng on 10/11/2016.
 */
public class LC8RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // dummy head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LC8RemoveDuplicatesfromSortedList l = new LC8RemoveDuplicatesfromSortedList();
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(0);
        l.deleteDuplicates(head);
    }
}

