package main.java;

/**
 * Created by joyfeng on 11/15/2016.
 */
public class LC148SortList {
    //    使用归并排序。
    //    首先需要把链表分成左右两部分，使用快慢指针法找到中间节点
    //    分别调用mergeSort对左右部分排序
    //    然后合并左右两个部分即可
    // Divide and Conquer
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)  return head;
        // find the middle node
        int nodeCount = 0;
        ListNode node = head;
        while (node != null) {
            nodeCount++;
            node = node.next;
        }

        node = head;
        for (int i = 1; i < nodeCount / 2; i++) {  // start from 1
            node = node.next;
        }

        // separate into 2 lists
        ListNode left = head;
        ListNode right = node.next;
        node.next = null;

        //
        ListNode merged = mergeTwoLists(sortList(left), sortList(right));
        return merged;
    }

    // LC 21 MergeTwoSortedLists
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] rgs) {
        LC148SortList l = new LC148SortList();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        l.sortList(head);
    }
}
