package main.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by joyfeng on 11/29/2016.
 */
public class LC202HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();

        while (!set.contains(n)) {
            set.add(n);
            n = getSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int c = n % 10;
            sum += c*c;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        LC202HappyNumber a = new LC202HappyNumber();
        a.isHappy(7);
    }
}
