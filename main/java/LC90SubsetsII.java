package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joyfeng on 10/6/2016.
 */
public class LC90SubsetsII {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // make sure you sort the array first
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<Integer>();
        dfs(nums, 0, tmp);

        return result;
    }

    void dfs (int[] nums, int start, List<Integer> tmp) {
        List<Integer> oneComb = new ArrayList<Integer>(tmp);
        result.add(oneComb);
        for (int i = start; i < nums.length; i++) {
            // do not include duplicates on the same position
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            tmp.add(nums[i]);
            dfs(nums, i+1, tmp);  // do not double include the current element
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC90SubsetsII l = new LC90SubsetsII();
        l.subsetsWithDup(new int[]{1,2,3});
        l.subsetsWithDup(new int[]{1,2,2});
    }
}
