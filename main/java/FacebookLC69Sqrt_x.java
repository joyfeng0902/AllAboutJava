package main.java;

/**
 * Created by joyfeng on 11/22/2016.
 */
public class FacebookLC69Sqrt_x {
    public int mySqrt(int x) {
        // A Simple Solution to find floor of square root is to try all numbers starting from 1.
        // For every tried number i, if i*i is smaller than x, then increment i.
        // We stop when i*i becomes more than or equal to x.
        // TLE
        if (x == 0 || x == 1) {
            return x;
        }
        int i = 1, result = 1;
        while (result < x) {
            i++;
            result = i * i;
            if (result == x) {
                return i;
            }
        }
        return i-1;
    }


    // 总结：这里有必要总结下binary search的一个规律
    //    当x不存在于一个sorted array A[0:n-1]中时，binary search的循环必然会因为start > end而终止。此时必然有：A[end] < x < A[start]，如果end >=0 且 start<n。
    //    这也就是为什么这题需要返回end，而Insertion Position那题却要返回start的原因。
    public int mySqrtUsingBinarySearch(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int low = 0, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x/mid == mid) {  // !! using x/mid instead of mid*mid to avoid overflow
                return mid;
            } else if (x/mid < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        FacebookLC69Sqrt_x f = new FacebookLC69Sqrt_x();
        System.out.println(f.mySqrt(2147395600));
        System.out.println(f.mySqrt(5));
        System.out.println(f.mySqrt(9));
        System.out.println(f.mySqrtUsingBinarySearch(2147395600));
        System.out.println(f.mySqrtUsingBinarySearch(5));
        System.out.println(f.mySqrtUsingBinarySearch(9));
    }
}
