package main.java;

/**
 * Created by joyfeng on 11/26/2016.
 */
public class GoogleLC231PowerofTwo {
    //    If a number is power of 2, it's binary form should be 10...0.
    //    So if we right shift a bit of the number and then left shift a bit,
    //    the value should be the same while the number >= 10(i.e.,2).
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 2) {  // both 1 and 2 are power of 2
            // if the last bit is 1, for example 3 (011), 011 >> 1 = 001, 001 << 1 = 010
            int t = n >> 1;
            int c = t << 1;
            if (n != c) {
                return false;
            }
            n = n >> 1;
        }
        return true;
    }

    // If a number is power of 2, then its highly bit is 1 and there is only one 1. Therefore, n & (n-1) is 0.
    public boolean isPowerOfTwo2(int n) {
        return n>0 && (n&n-1)==0;
    }

    public static void main(String[] args) {
        GoogleLC231PowerofTwo g = new GoogleLC231PowerofTwo();
        g.isPowerOfTwo(3);
    }
}
