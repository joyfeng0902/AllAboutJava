package main.java;

public class LC414ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        // using long instead of int for cases like
        // [1,2,-2147483648]
        // should return -2147483648
        // Integer.MIN_VALUE = -2147483648
        long max = Long.MIN_VALUE; // the largest
        long mid = Long.MIN_VALUE;
        long min = Long.MIN_VALUE;
        int count = 0; // "count" is used for checking whether found top 3 maximum elements.

        for (int i = 0; i < nums.length; i++) {
            long n = nums[i];
            if (n > max) {
                min = mid;
                mid = max;
                max = n;
                count++;
            } else if (n < max && n > mid) {
                min = mid;
                mid = n;
                count++;
            } else if (n < mid && n > min) {
                min = n;
                count++;
            }
        }

        return (count >= 3) ? (int)min : (int)max;
    }
}
