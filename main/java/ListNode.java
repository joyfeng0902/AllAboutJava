package main.java;

import java.util.HashMap;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x; next = null;
    }

    private static ListNode addTwoNumbersInReversedOrder(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    // remove duplicates from unsorted a linked list
    // very tricky
    private static void removeDuplicate(ListNode l1) {
        ListNode p = l1, q, dup;
        HashMap<Integer, Integer> ht = new HashMap();
        while (p != null && p.next != null) {
            q = p;
            while (q.next != null) {
                if (p.val == q.next.val) {
                    dup = q.next;
                    q.next = q.next.next;
                    dup = null;
                } else {
                    q = q.next;   // go to the next node
                }
            }
            p = p.next;        // go to the next node
        }
    }

    // insert a new node at the front of the list


    // Find n’th node from the end of a Linked List
    // 1. get the length of the list
    // 2. get the nth from the last
    static void printNthFromLast(ListNode l, int n) {
        int length = 0, i = 0;
        ListNode dummy = l;
        while (dummy != null) {
            length++;
            dummy = dummy.next;
        }

        if (length < n) {
            return;
        }
        dummy = l;
        // get (length-n+1)th node
        while (i < (length-n)) {
            dummy = dummy.next;
            i++;
        }

        System.out.println("The " + n + "th from the last is " + dummy.val);
    }

    // 1. main and reference pointers initialized = the head
    // 2. first move reference pointer to n
    // 3. then move both of them until the reference reach the end
    // 4 .return main pointer
    static void printNthFromLastUsingTwoPointers(ListNode l, int n) {
        ListNode mainPointer = l, refPointer = l;
        if (l != null) {   // need to check if head is null or not
            for (int i = 0; i < n; i++) {
                if (refPointer == null) {
                    System.out.println("Error: n > the length of the list.");
                    return;
                }
                refPointer = refPointer.next;
            }

            while (refPointer != null) {
                refPointer = refPointer.next;
                mainPointer = mainPointer.next;
            }

            System.out.println("The " + n + "th from the last is " + mainPointer.val);
            }
        }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.println("Node val is: " + node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(9);

        System.out.println("Start printing l1");
        printList(l1);
        System.out.println("Start printing l2");
        printList(l2);

        ListNode rtn = addTwoNumbersInReversedOrder(l1, l2);
        System.out.println("Start printing rtn");
        printList(rtn);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(4);
        l3.next.next = new ListNode(9);
        l3.next.next.next = new ListNode(9);
        l3.next.next.next.next = new ListNode(9);
        l3.next.next.next.next.next = new ListNode(11);
        removeDuplicate(l3);
        System.out.println("Start printing l3");
        printList(l3);

        ListNode l4 = new ListNode(2);
        l4.next = new ListNode(4);
        l4.next.next = new ListNode(9);
        l4.next.next.next = new ListNode(9);
        l4.next.next.next.next = new ListNode(9);
        l4.next.next.next.next.next = new ListNode(9);
        removeDuplicate(l4);
        System.out.println("Start printing l4");
        printList(l4);

        ListNode l5 = new ListNode(2);
        l5.next = new ListNode(4);
        l5.next.next = new ListNode(9);
        l5.next.next.next = new ListNode(12);
        l5.next.next.next.next = new ListNode(19);
        l5.next.next.next.next.next = new ListNode(22);
        System.out.println("Start printing l5");
        printNthFromLast(l5, 6);
    }
}

