package main.java;

import java.util.HashSet;
import java.util.Set;

public class GoogleLC128LongestConsecutiveSequence {
    // Because it requires O(n) complexity, we can not solve the problem by sorting the array first.
    // Sorting takes at least O(nlogn) time.
    // Using HashSet. Elements are not ordered. The add, remove and contains methods have constant time complexity O(1).
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rtn = 0;
        Set<Integer> set = new HashSet<Integer>();
        // add all elements in set
        for (int num : nums) {   // !! not for(num : nums)
            set.add(num);
        }
        for (int num : nums) {
            int left = num-1;
            int right = num+1;
            int count = 1;   // num already in set
            while (set.contains(left)) {
                count++;
                set.remove(left);     // remove to avoid duplicate calculation
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            rtn = Math.max(rtn, count);
        }

        return rtn;
    }

    // bucket sort: not good if we have very large number or overflow
    public int longestConsecutiveUsingBucketSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxNum = 0, minNum = 0, offset = 0;  // offset is used to deal with negative numbers
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }
        if (minNum < 0) {
            offset = - minNum;
        }
        int[] bucket = new int[maxNum+1+offset];
        for (int num : nums) {
            bucket[num+offset]++;
        }
        int rtn = 0, i = 0;
        while (i < bucket.length) {
            while (bucket[i] == 0) {
                i++;
                continue;
            }
            int count = 0;
            while (i < bucket.length && bucket[i] > 0) {
                count++;
                i++;
            }

            rtn = Math.max(rtn, count);
        }

        return rtn;
    }

    public static void main (String[] args) {
        GoogleLC128LongestConsecutiveSequence l = new GoogleLC128LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2, 9, 23, 101, 5, 22, 10, 11, 24, 21, 12, 20, 19}));
        System.out.println(l.longestConsecutiveUsingBucketSort(new int[]{100, 4, 200, 1, 3, 2, 9, 23, 101, 5, 22, 10, 11, 24, 21, 12, 20, 19}));
        System.out.println(l.longestConsecutive(new int[]{-2, -1, 0, 3}));
        System.out.println(l.longestConsecutive(new int[]{1, 0, -1}));
        System.out.println(l.longestConsecutiveUsingBucketSort(new int[]{-2, -1, 0, 3}));
    }
}
