package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class GoogleLC163MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            result.add(helper(lower, upper));   // do not forget this case!!
            return result;
        }
        if (nums[0] > lower) {
            result.add(helper(lower, nums[0]-1));
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] > 1 || nums[i] - nums[i-1] < 0) {  // overflow
                result.add(helper(nums[i-1]+1, nums[i]-1));
            }
        }
        if (nums[nums.length - 1] < upper) {
            result.add(helper(nums[nums.length-1]+1, upper));
        }

        return result;
    }

    String helper(int start, int end) {
        if (start == end) {
            return Integer.toString(start);
        } else {
            return Integer.toString(start) + "->" + Integer.toString(end);
        }
    }

    public static void main (String[] args) {
        GoogleLC163MissingRanges g = new GoogleLC163MissingRanges();
        int[] nums = {-2147483648,2147483647};
        g.findMissingRanges(nums, -2147483648, 2147483647);
        int[] nums1 = {0, 99};
        g.findMissingRanges(nums1, 0, 99);
    }
}
