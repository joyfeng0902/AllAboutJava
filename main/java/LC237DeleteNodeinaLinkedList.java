package main.java;

/**
 * Created by joyfeng on 11/8/2016.
 */
public class LC237DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        // delete the node after it, and assign that node's val to the current node
        int tmp = node.next.val;
        node.next = node.next.next;
        node.val = tmp;
    }
}
