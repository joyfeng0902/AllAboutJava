package main.java;

import java.util.Arrays;

/**
 * Created by joyfeng on 10/26/2016.
 */
public class GoogleLC274HIndex {
    // Time complexity : O(n\log n)O(nlogn). Comparison sorting
    public int hIndex(int[] citations) {
        int h = 0;
        if (citations == null || citations.length == 0) {
            return h;
        }
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            // length - i: is the number of citations whose citation is >= citations[i]
            if (length-i <= citations[i]) {
                h = Math.max(h, length-i);
            }
        }
        return h;
    }

    public int hIndexByCountSorting(int[] citations) {
        // bucket sort
        // O(n)
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            count[Math.min(n, citations[i-1])]++;
        }

        int k = 0;
        for (int i = n; i > 0 ;i--) {
            k += count[i];
            if (k >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main (String [] args) {
        GoogleLC274HIndex s = new GoogleLC274HIndex();
        s.hIndexByCountSorting(new int[]{1, 1});
    }
}
