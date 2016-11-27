package main.java;

/**
 * Created by joyfeng on 11/16/2016.
 */
public class LC11ContainerWithMostWater {
    // the height is always determined by the lower line
    // starting from both sides,
    // if height(l) < height(r), need to find a higher line than height(l), so move to the right
    // if height(l) > height(r), need to find a higher line than height(r), so move to the left
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int l = 0, r = height.length-1;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r-l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LC11ContainerWithMostWater l = new LC11ContainerWithMostWater();
        l.maxArea(new int[]{1,1});
    }
}
