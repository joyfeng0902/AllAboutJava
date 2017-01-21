package main.java;

public class FacebookLC172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        // 除了计算n/5， 还要计算n/5/5, n/5/5/5, n/5/5/5/5, ..., n/5/5/5,,,/5直到商为0，然后就和，就是最后的结果
        return n / 5 == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public int trailingZeroes2(int n) {
        int count = 0;
        while (n/5 > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
