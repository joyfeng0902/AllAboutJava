package main.java;

/**
 * Created by joyfeng on 12/21/2016.
 */
public class LC83RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {  // remove the next element
                head.next = head.next.next;
            } else {
                head = head.next;  // remove the next element until no duplicate
            }
        }

        return dummy.next;
    }
}
