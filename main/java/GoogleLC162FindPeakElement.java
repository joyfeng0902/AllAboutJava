package main.java;

/**
 * Created by liaomiao on 10/27/2016.
 */
public class GoogleLC162FindPeakElement {
    public int findPeakElement(int[] nums) {
        // binary seach
        // because num[-1] = num[n] = -∞ there must be a peak in the middle
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid+1]) {
                // search in the right part
                left = mid+1;
            } else {
                // search in the left part
                right = mid;
            }
        }

        return left;
    }
}
