package main.java;

/**
 * Created by joyfeng on 12/17/2016.
 */
public class LC313SuperUglyNumber {
    // use the same idea as LC264UglyNumberII
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] index = new int[len]; //index[0]==0, ... index[len-1]==0
        int[] ugly = new int[n];
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                min = Math.min(min, primes[j] * ugly[index[j]]);
            }
            ugly[i] = min;
            for (int j = 0; j < len; j++) {
                if (ugly[i] % primes[j] == 0) {
                    index[j]++;
                }
            }
        }

        return ugly[n-1];
    }
}
