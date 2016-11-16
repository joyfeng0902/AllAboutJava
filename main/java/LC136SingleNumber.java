package main.java;

/**
 * Created by joyfeng on 11/3/2016.
 */
public class LC136SingleNumber {
    public int singleNumber(int[] nums) {
        // XOR, exclusive OR
        // any number n^n = 0, 0^n = n
        int res = 0;
        for (Integer num : nums) {
            res ^= num;
        }

        return res;
    }
}
