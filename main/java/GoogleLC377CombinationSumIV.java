package main.java;

import java.util.LinkedList;
import java.util.List;

public class GoogleLC377CombinationSumIV {
    // using depth first search will time out given [4,1,2] 32 as input
    // sometimes n! is too big and will overflow
    // the correct is to use DP
    // if allow negative elements, will have to limit the number of occurrence for each element
    // for example, [-1, 1] 1 can have unlimited possible combinations
    public int combinationSum4(int[] nums, int target) {
        // dp[i]: the number of possible combinations that add up to i
        int[] dp = new int[target+1];
        dp[0] = 1;   // there is 1 way to create empty list
        for (int i = 0; i <= target; i++) {
            for (int n : nums) {
                if (i+n <= target) {
                    dp[i+n] += dp[i];
                }
            }
        }
        return dp[target];
    }
}
