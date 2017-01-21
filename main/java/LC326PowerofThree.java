package main.java;

/**
 * Created by joyfeng on 11/27/2016.
 */
public class LC326PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }

        while (n > 0) {
            int m = n%3;
            if (m == 0) {  // can divide 3
                n /= 3;  // /3 get a new n
                if (n == 1) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }
}
