package main.java;

/**
 * Created by joyfeng on 11/8/2016.
 */
public class LC191Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }

        return count;
    }
}
