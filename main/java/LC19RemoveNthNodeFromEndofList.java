package main.java;

public class LC19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // initially slow and fast are at the same start point
        ListNode slow = dummy, fast = dummy;
        //Move fast in front so that the gap between slow and fast becomes n
        while (n > 0){
            fast = fast.next;
            n--;
        }

        //Move fast to the end, maintaining the gap
        // when fast is at the very end of the list, slow is right before the node to be deleted
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //Skip the desired node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
