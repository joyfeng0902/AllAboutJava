package main.java;

/**
 * Created by joyfeng on 11/16/2016.
 */
public class LC198HouseRobber {
    // DP. easy!!
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);   // !! do not forget this base case
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,10,3,1,5};
        int result = rob(nums);
        System.out.println(result);
    }
}
