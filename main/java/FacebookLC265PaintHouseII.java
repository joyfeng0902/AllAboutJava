package main.java;

/**
 * Created by joyfeng on 11/24/2016.
 */
public class FacebookLC265PaintHouseII {
    // DP
    // changing function: dp[i][j] = min(dp[i-1].begin(), dp[i-1].end()) + costs[i][j], 并且列不为j．
    // 最朴素的方式时间复杂度为O(n*k*k)，即三层循环，分别是①遍历所有的房子．②遍历这个房子的所有颜色方案．③对于每种方案寻找上一个房子除了染这个颜色的最小代价．
    // 而空间复杂度则为O(n*k).

    // 如果当前行cost最小的颜色和上一行所选择的颜色相同,那这个颜色就不能选了,我们应该选择第二小的,
    // 我们需要记录每一行cost最小的位置及cost第二小的位置,遍历过程中,并及时更新相关的值。
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        // n is the number of houses, k is the number of colors
        int n = costs.length, k = costs[0].length;
        // min1: the color index for the current house which makes the cost smallest
        // min2: the color index for the current house which makes the cost second smallest
        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
            // each time before processing each house, reset min1, min2, set last1, last2
            // last1: the color index for the previous house which makes the cost smallest
            // last2: the color index for the previous house which makes the cost second smallest
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;
            for (int j = 0; j < k; j++) {
                /// if j != last1, then  the previous house can pick color indexed at last1; else pick last2
                if (j != last1) {
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }
                // update min1, min2
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        return costs[n - 1][min1];
    }
}
