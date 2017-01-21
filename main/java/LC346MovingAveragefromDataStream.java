package main.java;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by joyfeng on 11/26/2016.
 */
public class LC346MovingAveragefromDataStream {
    private Queue<Integer> queue;
    private int capacity;
    private double average;

    /** Initialize your data structure here. */
    public LC346MovingAveragefromDataStream(int size) {
        queue = new LinkedList<Integer>();
        capacity = size;
    }

    public double next(int val) {
        double sum = average * queue.size();
        while (queue.size() >= capacity) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        average = sum / queue.size();
        return average;
    }

    public static void main(String[] args) {
        LC346MovingAveragefromDataStream g = new LC346MovingAveragefromDataStream(3);
        g.next(1);
        g.next(10);
        g.next(3);
        g.next(5);
    }
}
