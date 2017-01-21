package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joyfeng on 11/21/2016.
 */
public class LC1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();  // value to index
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
