package main.java;

/**
 * Created by joyfeng on 11/22/2016.
 */
public class GoogleLC50Pow_x_n {
    public double myPow(double x, int n) {
        // Time Complexity: O(lgn)
        // x^n = (x^(n/2)) * (x^(n/2))
        // take care of th case when n is negative
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        int t = n / 2;
        if (n < 0) {
            t = -t;
            x = 1/x;
        }
        double res = myPow(x, t);
        if (n % 2 == 0) {
            return res * res;
        }
        return res * res * x;
    }
}
