package main.java;

import java.util.*;

/**
 * Created by joyfeng on 10/20/2016.
 */
public class LC347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // using PriorityQueue
        // see how Priority constructs. must specify size
        // PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(map.size(),
                new Comparator<Map.Entry<Integer, Integer>>() {
            // Must be public
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getValue() - b.getValue();
            }
        });

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            queue.offer(iterator.next());
            if (queue.size() > k) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            res.add(queue.poll().getKey());
        }

        // sort
        Collections.reverse(res);

        return res;
    }
}
