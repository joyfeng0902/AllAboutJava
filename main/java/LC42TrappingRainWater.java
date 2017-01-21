package main.java;

/**
 * Created by joyfeng on 12/24/2016.
 */
public class LC42TrappingRainWater {
    public int trap(int[] height) {
        // at each i, get the max height on its left and right excluding i, and get the min of these two - Hmin
        // if Hmin <= A[i], s = 0; else s = Hmin - A[i]
        if (height == null || height.length < 3) {
            return 0;
        }

        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;
        // left[0] = 0
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i-1]);
        }

        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
            int minHeight = Math.min(left[i], right[i]);
            res += (minHeight > height[i]) ? minHeight - height[i] : 0;
        }

        return res;
    }
}
