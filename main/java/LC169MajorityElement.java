package main.java;

import java.util.Arrays;

public class LC169MajorityElement {
    // you could sort the array and then get the middle element, which is guaranteed to be the element that appears more than ⌊ n/2 ⌋ times.
    // Now we implement it using Moore's Voting algorithm
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int count = 1, majIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[majIndex] == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                count = 1;
                majIndex = i;
            }
        }
        return majIndex;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
