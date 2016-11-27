package main.java;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by joyfeng on 11/26/2016.
 */
public class GoogleLC346MovingAveragefromDataStream {
    private Queue<Integer> queue;
    private int capacity;
    private double avg;

    /** Initialize your data structure here. */
    public GoogleLC346MovingAveragefromDataStream(int size) {
        queue = new LinkedList<Integer>();
        capacity = size;
    }

    public double next(int val) {
        queue.offer(val);
        if (queue.size() <= capacity) {
            // iterate the queue, and get the sum
            int sum = 0;
            for (int num : queue) {
                sum += num;
            }
            avg = (double)sum / queue.size();
        } else {
            int head = queue.poll();
            avg = (avg * queue.size() - head + val) / queue.size();
        }
        return avg;
    }

    public static void main(String[] args) {
        GoogleLC346MovingAveragefromDataStream g = new GoogleLC346MovingAveragefromDataStream(3);
        g.next(1);
        g.next(10);
        g.next(3);
        g.next(5);
    }
}
