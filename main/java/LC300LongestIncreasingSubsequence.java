package main.java;

public class LC300LongestIncreasingSubsequence {
    // M holds in M[i] the index of the smallest number from S,
    //  where there is an increasing subsequence with length i ending with the number S[M[i]]
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] f = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;  // each element itself is a subsequence

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                }
            }
            max = Math.max(max, f[i]);
        }

        return max;
    }

    // O(nlgn)
    // The observation is, when we encounter new smallest element in the array, it can be a potential candidate to start new sequence.
    //    1. If A[i] is smallest among all end
    //    candidates of active lists, we will start
    //    new active list of length 1.
    //    2. If A[i] is largest among all end candidates of
    //    active lists, we will clone the largest active
    //    list, and extend it by A[i].
    //    3. If A[i] is in between, we will find a list with
    //    largest end element that is smaller than A[i].
    //    Clone and extend this list by A[i]. We will discard all
    //    other lists of same length as that of this modified list.
    //    Note that at any instance during our construction of active lists, the following condition is maintained.
    //
    //    “end element of smaller list is smaller than end elements of larger lists”.
}
