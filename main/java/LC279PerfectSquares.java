package main.java;

import java.util.Arrays;

/**
 * Created by joyfeng on 10/23/2016.
 */
public class LC279PerfectSquares {
    // DP
    // dp[i] = min(dp[i], dp[i-square]+1)
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                min = Math.min(min, dp[i-j*j] + 1);
            }
            dp[i] = min;
        }

        return dp[n];
    }
}
