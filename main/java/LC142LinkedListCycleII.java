package main.java;

/**
 * Created by joyfeng on 12/13/2016.
 */
public class LC142LinkedListCycleII {
    // https://discuss.leetcode.com/topic/19367/java-o-1-space-solution-with-detailed-explanation/2
    // see the diagram
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {  // odd or even number of elements
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {  // when they meet, there is cycle
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }

                return slow;
            }
        }

        return null;
    }
}
