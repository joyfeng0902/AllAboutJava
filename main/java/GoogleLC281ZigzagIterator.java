package main.java;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Zigzag Iterator
 Given two 1d vectors, implement an iterator to return their elements alternately.
 For example, given two 1d vectors:
 v1 = [1, 2]
 v2 = [3, 4, 5, 6]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 Clarification for the follow up question - Update (2015-09-18):
 The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
 [1,2,3]
 [4,5,6,7]
 [8,9]
 It should return [1,4,8,2,5,9,3,6,7].
 */
public class GoogleLC281ZigzagIterator {
    // think of k lists
    // keep a list of k iterators
    // using Queue: whenever we encounter problem with circular behavior, we use poll and offer in Queue
    private Queue<Iterator<Integer>> queue;
    public GoogleLC281ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Iterator<Integer>>();
        if (v1 != null && v1.size() > 0) {
            queue.offer(v1.iterator());
        }
        if (v2 != null && v2.size() > 0) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        if (!hasNext()) {
            return 0;
        }

        Iterator<Integer> cur = queue.poll();
        int tmp = cur.next();
        // if still has elements, add to queue
        if (cur.hasNext()) {
            queue.offer(cur);
        }

        return tmp;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        List<Integer> v1 = new ArrayList();
        v1.add(1);
        v1.add(2);
        List<Integer> v2 = new ArrayList();
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);
        GoogleLC281ZigzagIterator g = new GoogleLC281ZigzagIterator(v1, v2);
        while(g.hasNext()) {
           System.out.println(g.next());
        }
    }
}
