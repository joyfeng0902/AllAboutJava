package main.java;

import java.util.Random;

/**
 * Created by joyfeng on 11/24/2016.
 */
public class FacebookLC398RandomPickIndex {
    //  Reservoir Sampling
    //  Reservoir sampling is a family of randomized algorithms for randomly choosing a sample of k items /
    //  from a list S containing n items, where n is either a very large or unknown number.
    private int[] nums;
    private Random random;

    public FacebookLC398RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        // !!有模板
        int res = -1;
        if (nums == null || nums.length == 0) {
            return res;
        }
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (random.nextInt(count) == 0) {
                    res = i;
                }
                count++;
            }
        }
        return res;
    }
}
