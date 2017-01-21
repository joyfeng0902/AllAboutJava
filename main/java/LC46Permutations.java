package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class LC46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        helper(result, new ArrayList<Integer>(), nums);

        return result;
    }

    void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            helper(res, tmp, nums);
            tmp.remove(tmp.size()-1);
        }
    }
}
