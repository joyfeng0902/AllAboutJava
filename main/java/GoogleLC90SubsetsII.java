package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joyfeng on 11/24/2016.
 */
public class GoogleLC90SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // make sure you sort the array first
        Arrays.sort(nums);
        helper(nums, result, new ArrayList<Integer>(), 0);

        return result;
    }

    void helper(int[] nums, List<List<Integer>> result, List<Integer> tmp, int start) {
        result.add(new ArrayList<Integer>(tmp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            tmp.add(nums[i]);
            helper(nums, result, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        GoogleLC90SubsetsII l = new GoogleLC90SubsetsII();
        l.subsetsWithDup(new int[]{1,2,3});
        l.subsetsWithDup(new int[]{1,2,2});
    }
}
