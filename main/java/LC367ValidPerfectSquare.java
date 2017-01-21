package main.java;

public class LC367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        // binary search
        if (num == 1) {
            return true;
        }

        // use long for mid to avoid mid*mid from overflow like 808201.
        long i = 1, j = num/2;
        long nums = (long)num;
        while (i <= j) {
            long mid = i + (j-i) / 2;
            if ((mid * mid) == nums) {
                return true;
            } else if ((mid * mid) < nums) {
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC367ValidPerfectSquare l = new LC367ValidPerfectSquare();
        l.isPerfectSquare(808201);
    }
}
