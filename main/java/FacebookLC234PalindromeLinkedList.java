package main.java;

/**
 * Created by joyfeng on 11/25/2016.
 */
public class FacebookLC234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {   // no element or only 1 element
            return true;
        }
        // use a fast and slow pointer to get the center of the list
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // divide the lisst into 2 parts
        ListNode secondHead = slow.next;  // start of the second part
        slow.next = null;  // end of the first part

        // reverse the second list
        secondHead = reverseIterative(secondHead);

        // compare two sublists
        while (secondHead != null) {
            if (head.val != secondHead.val) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }

        return true;
    }

    // http://algorithms.tutorialhorizon.com/reverse-a-linked-list/
    // !!
    public ListNode reverseIterative(ListNode head){
        ListNode currNode = head;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while(currNode!=null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        FacebookLC234PalindromeLinkedList f = new FacebookLC234PalindromeLinkedList();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(1);
        f.isPalindrome(l);
    }
}
