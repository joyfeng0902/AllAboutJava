package main.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false.
 */
public class FacebookLC252MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval l1, Interval l2) {
                if (l1.start == l2.start) {
                    return l1.end - l2.end;
                } else {
                    return l1.start - l2.start;
                }
            }
        });

        Interval prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = intervals[i];
            if (prev.end > curr.start) {
                return false;
            }
            prev = curr;  // do not forget!!
        }

        return true;
    }

    public static void main(String[] args) {
        FacebookLC252MeetingRooms f = new FacebookLC252MeetingRooms();
        Interval[] intervals = {new Interval(6,10), new Interval(13,14),new Interval(12,14)};
        System.out.print(f.canAttendMeetings(intervals));
    }
}
