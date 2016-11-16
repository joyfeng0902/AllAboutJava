package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyfeng on 10/27/2016.
 */
public class GoogleLC57InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        // |---curr--|   |---newInterval---|
        // |---newInterval---|    |---curr---|
        // has overlapping
        for (int i = 0; i < intervals.size(); i++) {
            // becasue you do not new the newInterval start, you have to consider all cases
            Interval curr = intervals.get(i);
            if (curr.end < newInterval.start) {
                result.add(curr);
            } else if (curr.start > newInterval.end) {
                result.add(newInterval);
                newInterval = curr;
            } else {
                newInterval = new Interval(Math.min(curr.start, newInterval.start), Math.max(newInterval.end, curr.end));
            }
        }

        result.add(newInterval);

        return result;
    }
}
