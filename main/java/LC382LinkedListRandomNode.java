package main.java;

import java.util.Random;

/**
 * Created by joyfeng on 10/23/2016.
 */
public class LC382LinkedListRandomNode {
    // we want the possibility of beng chosen is 1/count
    // reservoir sampling
    Random r = null;
    ListNode h = null;

    public LC382LinkedListRandomNode(ListNode head) {
        r = new Random();
        h = head;
    }

    // returns a random node's value
    public int getRandom() {
        int count = 1;
        ListNode p = h;  // h cannot be changed after getRandom is called
        int result = 0;
        while (p != null) {
            if (r.nextInt(count) == 0) {  //nextInt(n) returns a random number between 0(inclusive) and n(exclusive)
                result = p.val;
            }
            count++;
            p = p.next;
        }
        return result;
    }
}
