package main.java;

/**
 * Created by joyfeng on 12/12/2016.
 */
public class LC53MaximumSubarray {
    // it starts at the left end (element A[1]) and scans through to the right end (element A[n]), keeping track of the maximum sum subvector seen so far
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = maxEndingHere < 0 ? nums[i] : maxEndingHere + nums[i];
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
