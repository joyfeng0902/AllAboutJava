package main.java;

public class LC27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[begin++] = nums[i];
            }
        }

        // do not return begin+1, begin already ++
        return begin;
    }
}
