package main.java;

/**
 * Created by joyfeng on 11/17/2016.
 */
public class FacebookLC238ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length-1] = 1;
        for (int i = 0; i < nums.length-1; i++) {
            left[i+1] = left[i] * nums[i];
        }
        for (int i = nums.length-1; i > 0; i--) {
            right[i-1] = right[i] * nums[i];
        }

        // multiply
        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
