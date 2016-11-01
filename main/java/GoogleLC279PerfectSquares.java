package main.java;

import java.util.Arrays;

/**
 * Created by joyfeng on 10/23/2016.
 */
public class GoogleLC279PerfectSquares {
    // DP
    // dp[i] = min(dp[i], dp[i-square]+1)
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);  // don't forgot this step, or it will return 0
        //dp[1] = 1;
        //dp[2] = dp[1] + dp[2-1] = 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i == j*j) {
                    dp[i] = 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[i-j*j] + 1);  // find the min
                }
            }
        }
        return dp[n];
    }
}
