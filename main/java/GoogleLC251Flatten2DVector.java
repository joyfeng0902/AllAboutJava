package main.java;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement an iterator to flatten a 2d vector.

 For example, Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */
public class GoogleLC251Flatten2DVector {
    // keep a list of iterators
    // check if it is empty before add to queue
    Queue<Iterator<Integer>> queue;

    GoogleLC251Flatten2DVector(List<List<Integer>> vec2d) {
         queue = new LinkedList<Iterator<Integer>>();
         for (int i = 0; i < vec2d.size(); i++) {
             List<Integer> list = vec2d.get(i);
             if (list != null && !list.isEmpty()) {
                 queue.offer(list.iterator());
             }
         }
    }
    public int next() {
        if (queue.isEmpty()) {
            return 0;
        }

        Iterator<Integer> cur = queue.peek();  // only read the first element
        int tmp = cur.next();
        if (!cur.hasNext()) {
            queue.poll();
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
        List<List<Integer>> vec2d = new LinkedList<List<Integer>>();
        vec2d.add(v1);
        vec2d.add(v2);
        GoogleLC251Flatten2DVector g = new GoogleLC251Flatten2DVector(vec2d);
        while(g.hasNext()) {
            System.out.println(g.next());
        }
    }
}
