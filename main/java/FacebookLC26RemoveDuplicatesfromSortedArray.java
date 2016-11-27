package main.java;

/**
 * Created by joyfeng on 11/20/2016.
 */
public class FacebookLC26RemoveDuplicatesfromSortedArray {
    // Since the array is already sorted, we can keep two pointers ii and jj,
    // where ii is the slow-runner while jj is the fast-runner.
    // As long as nums[i] = nums[j]nums[i]=nums[j], we increment jj to skip the duplicate.
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = i+1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
