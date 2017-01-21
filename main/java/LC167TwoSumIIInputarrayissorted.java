package main.java;

/**
 * Created by joyfeng on 1/3/2017.
 */
public class LC167TwoSumIIInputarrayissorted {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i + 1 < j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i+1, j+1};
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        if (nums[i] + nums[j] == target) {
            return new int[]{i+1, j+1};
        }

        return new int[]{-1, -1};
    }
}
