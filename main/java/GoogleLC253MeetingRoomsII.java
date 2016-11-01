package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2.
 */

// Definition for an interval.
public class GoogleLC253MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        int res = 0;
        if (intervals == null || intervals.length == 0) {
            return res;
        }
        // sort
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval l1, Interval l2) {
                return l1.start - l2.start;
            }
        });

        // Using PriorityQueue to sort the end time asc
        // Creates a PriorityQueue that orders its elements according to their natural ordering.
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= queue.peek()) {
                queue.poll();  // leave and give the room to i
            }
            queue.offer(intervals[i].end);
        }
        return queue.size();
    }
}
