package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by liaomiao on 10/25/2016.
 */
public class GoogleLC23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // using PriorityQueue
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1,ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode list : lists) {  // lisst is the head node of each list
            if (list != null) {  // do not forget to check
                queue.offer(list);
            }
        }

        ListNode head = new ListNode(0);
        ListNode p = head;

        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            p.next = tmp;
            p = p.next;

            if (tmp != null && tmp.next != null) {  // add the next element to the queue
                queue.offer(tmp.next);
            }
        }

        return head.next;
    }
}
