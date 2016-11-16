package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by joyfeng on 10/25/2016.
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class GoogleLC56MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        // first you have to sort the itervals
        // sort by start first, then end, in asc order
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return  result;
        }

        // sort the intervals
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval l1, Interval l2) {
                if (l1.start == l2.start) {
                    return l1.end - l2.end;
                } else {
                    return l1.start - l2.start;
                }
            }
        });

        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval l = intervals.get(i);
            if (prev.end < l.start) {
                result.add(prev);
                prev = l;
            } else {
                prev = new Interval(prev.start, Math.max(prev.end, l.end));
            }
        }
        result.add(prev);

        return result;
    }
}
