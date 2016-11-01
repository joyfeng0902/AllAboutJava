package main.java;

/**
 * Created by joyfeng on 10/14/2016.
 */
public class LC260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        // bit manipulation
        int xor = 0;
        int[] res = new int[2];
        for (int num : nums) {
            xor^=num;
        }
        int lowbit = xor&-xor; // two's supplement  6:0110, -6:1001+1 = 1010
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
