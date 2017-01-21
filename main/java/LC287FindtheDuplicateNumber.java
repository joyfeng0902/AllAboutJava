package main.java;

/**
 * Created by joyfeng on 12/13/2016.
 */
public class LC287FindtheDuplicateNumber {
    // http://blog.csdn.net/monkeyduck/article/details/50439840
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);  // there is ;

        int find = 0;
        while (find != slow) {
            find = nums[find];
            slow= nums[slow];
        }

        return find;
    }
}
