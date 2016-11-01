package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyfeng on 10/4/2016.
 */
public class GoogleLC228SummaryRanges {
    //For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
    public List<String> summaryRanges(int[] nums) {
        // 2 pointers
        // initially start=end=0
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int length = nums.length, start = 0, end = 0;
        // starting from index 1, cmpare [i] and [i-1], if difference is 1, range++
        // else if range == 0, print the single number; if > 0 print range
        // get a new prev
        while(end < length) {
            if (end+1 < length && nums[end] + 1 == nums[end+1]) {
                end++;
            } else { // add new range in result
                if (start == end) {
                    result.add(Integer.toString(nums[start]));
                } else {
                    result.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[end]));
                }

                end++; // move to the next
                start = end;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GoogleLC228SummaryRanges l = new GoogleLC228SummaryRanges();
        l.summaryRanges(new int[]{0,1});
    }
}
