package main.java;

import java.util.PriorityQueue;

/**
 * Created by joyfeng on 11/25/2016.
 */
public class FacebookLC215KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        //  We can use a min heap to solve this problem. The heap stores the top k elements.
        // Whenever the size is greater than k, delete the min. Time complexity is O(nlog(k)).
        // Space complexity is O(k) for storing the top k numbers.
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}
