package main.java;

/**
 * Created by joyfeng on 10/7/2016.
 */
public class FacebookLC80RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // if occur more than twice, overwrite it with the next different number
        int index = 0, count = 1;  // index: new array index; count: how many times each number occurs
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {  // if the same as the previous one
                if (count == 2) {  // if count already == 2, continue to the next number
                    continue;
                }
                count++;
                index++;
            } else {
                count = 1;  // if different, reset count
                index++;
            }
            nums[index] = nums[i];
        }

        return index + 1;
    }

    public static void main(String[] args) {
        FacebookLC80RemoveDuplicatesfromSortedArrayII l = new FacebookLC80RemoveDuplicatesfromSortedArrayII();
        l.removeDuplicates(new int[]{1,2});
    }
}
