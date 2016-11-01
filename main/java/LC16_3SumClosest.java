package main.java;

import java.util.Arrays;

/**
 * Created by joyfeng on 10/13/2016.
 */
public class LC16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length, min = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < length - 2; i++) {
            int low = i+1, high=length-1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) {
                    return sum;
                } else {
                    int diff = Math.abs(sum-target);
                    if (diff < min) {
                        min = diff;
                        result = sum;
                    }
                    if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return result;
    }
}
