package main.java;

/**
 * Created by joyfeng on 10/15/2016.
 */
public class LC190ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for(int i = 0; i < 16; i++) {
            //swap bits
            n = swapBits(n, i, 32-i-1);
        }
        return n;
    }

    public int swapBits(int n, int i, int j) {
        int a = (n>>i) & 1; // get the ith bit
        int b = (n>>j) & 1; // get the jth bit

        if ((a^b) != 0) { // if a and b are different
            // swap
            return n^=(1<<i)|(1<<j);   // 1^1=0, 1^0=1
        }

        return n;
    }
}
