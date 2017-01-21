package main.java;

/**
 * Created by joyfeng on 12/29/2016.
 */
public class LC152MaximumProductSubarray {
    // Loop through the array, each time remember the max and min value for the previous product,
    // update the max and min value: we have to compare among max * A[i], min * A[i] as well as A[i]
    // consider case: [0, 2]  [2, -5, -2, -4, 3]
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int min = nums[0], max = nums[0], result = nums[0];

        for (int i = 1; i < n; i++) {
            int tmp = min;
            min = Math.min(Math.min(min*nums[i], max*nums[i]), nums[i]);
            max = Math.max(Math.max(tmp*nums[i], max*nums[i]), nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}
