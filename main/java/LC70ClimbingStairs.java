package main.java;

/**
 * Created by joyfeng on 10/8/2016.
 */
public class LC70ClimbingStairs {
    public int climbStairs(int n) {
        // recursion is quite consuming, causing timeout
        if (n < 3) {
            return n;
        }
        int f1 = 1, f2 = 2;
        for (int i = 3; i <=n; i++) {
            int tmp = f2;
            f2 = f1+f2;
            f1 = tmp;
            // or you do not need tmp
            // f2 = f1+f2;
            // f1 = f2-f1;
        }
        return f2;
    }
}
