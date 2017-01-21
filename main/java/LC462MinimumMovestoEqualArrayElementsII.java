package main.java;

import java.util.Arrays;

/**
 * Created by joyfeng on 12/28/2016.
 */
public class LC462MinimumMovestoEqualArrayElementsII {
    // 求数组各元素与中位数差的绝对值之和
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int sum = 0;
        while (i < j) {
            sum += nums[j] - nums[i];
            i++;
            j--;
        }

        return sum;
    }
}
