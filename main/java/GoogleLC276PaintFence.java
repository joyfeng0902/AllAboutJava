package main.java;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color.

 Return the total number of ways you can paint the fence.
 */
public class GoogleLC276PaintFence {
    // 如果前两根栅栏颜色相同，则第三根栅栏的颜色不能跟前两根的栅栏颜色相同;
    // 若是前两根栅栏颜色不同，则第三根栅栏颜色随便涂。
    // 综合的思想就是，第三根栅栏或者与第一根栅栏的颜色不同，或者与第二根的栅栏颜色不同。
    // 除了递推，还要考虑base 情况
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k*k;
        }
        int dp1 = k, dp2 = k*k, dp3 = k;
        for (int i = 3; i <= n; i++) {
            dp3 = (dp1 + dp2) * (k-1);
            dp1 = dp2;
            dp2 = dp3;
        }

        return dp3;
    }
}
