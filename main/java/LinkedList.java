package main.java;

public class LinkedList {
    ListNode head;

    void push(int new_data) {
        ListNode newNode = new ListNode(new_data);
        newNode.next = head;
        head = newNode;
    }

    void printListNodes() {
        ListNode h = this.head;
        while(h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    // Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
    void deleteNode(ListNode node) {
        if (node == null) {         // empty list
            return;
        }

        if (node.next == null) {    // remove the first and the only node
            head = null;
            return;
        }

        // remove the next node
        ListNode tmpNode = node.next;
        int tmpVal = tmpNode.val;
        node.next = tmpNode.next;
        node.val = tmpVal;
        tmpNode = null;

    }

    // Add two numbers represented by linked lists
    // see the use of dummyHead and curr
    static ListNode addLink(LinkedList list1, LinkedList list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2.head;
        if (list2 == null)  return list1.head;

        // smart use of dummyHead
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        ListNode p = list1.head;
        ListNode q = list2.head;
        int carry = 0;

        while(p != null || q != null) {
            int val1 = p == null ? 0 : p.val;
            int val2 = q == null ? 0 : q.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum %= 10;

            ListNode temp = new ListNode(sum);
            // dummyHead
            curr.next = temp;
            curr = curr.next;     // go to the next

//            p = p.next;
//            q = q.next;
            // make sure you check if p or q is null
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        // now both p and q are null
        if (carry > 1) {
            curr.next = new ListNode(1);
        }

        return dummyHead.next;
    }

    // TODO Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(3);
        list.push(4);
        list.push(5);
        list.printListNodes();
        ListNode.printNthFromLast(list.head, 1);
        ListNode.printNthFromLastUsingTwoPointers(list.head, 1);
        ListNode.printNthFromLastUsingTwoPointers(list.head, 10);
        ListNode.printNthFromLastUsingTwoPointers(list.head, 3);
        ListNode.printNthFromLastUsingTwoPointers(list.head, 4);
        ListNode.printNthFromLastUsingTwoPointers(null, 1);

        list.deleteNode(list.head);
        list.printListNodes();

        list = new LinkedList();
        list.push(3);
        list.deleteNode(list.head);
        list.printListNodes();

        LinkedList list1 = new LinkedList();
        list1.push(6);
        list1.push(4);
        list1.push(9);
        list1.push(5);
        list1.push(7);
        System.out.println("List1 is ");
        list1.printListNodes();

        LinkedList list2 = new LinkedList();
        list2.push(4);
        list2.push(8);
        System.out.println("List2 is ");
        list2.printListNodes();

        // add the two lists and see the result
        ListNode rs = addLink(list1, list2);
        LinkedList rsList = new LinkedList();
        rsList.head = rs;
        System.out.println("Resultant List is ");
        rsList.printListNodes();
    }
}
