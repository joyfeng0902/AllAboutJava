package main.java;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by joyfeng on 10/14/2016.
 */
public class LC384ShuffleanArray {
    int[] original;
    int[] shuffled;
    Random r;
    public LC384ShuffleanArray(int[] nums) {
        original = nums;
        shuffled = Arrays.copyOf(original, original.length);
        r = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int length = shuffled.length;
        for (int i = 0; i < length; i++) {
            // get a random number si between 0 and length-1
            // exchange [i] and [si]
            int si = r.nextInt(length);
            int tmp = shuffled[i];
            shuffled[i] = shuffled[si];
            shuffled[si] = tmp;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */