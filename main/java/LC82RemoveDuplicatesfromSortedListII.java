package main.java;

/**
 * Created by joyfeng on 10/11/2016.
 */
public class LC82RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // dummy head: becasue the head may be deleted
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int nextval = current.next.val;
                while (current.next != null && current.next.val == nextval) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}
