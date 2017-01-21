package main.java;

import java.util.Arrays;

/**
 * Created by joyfeng on 10/28/2016.
 */
public class LC259_3SumSmaller {
    // covert to 2SumSmaller
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length-2; i++) {
            count += twoSumSmaller(nums, i+1, target-nums[i]);
        }

        return count;
    }

    public int twoSumSmaller(int[] nums, int start, int target) {
        // 2 pointers
        int i = start, j = nums.length-1, count = 0;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                count += j - i;
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
