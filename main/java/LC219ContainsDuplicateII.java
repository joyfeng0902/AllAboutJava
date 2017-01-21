package main.java;

import java.util.HashMap;
import java.util.Map;

public class LC219ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int pre = map.get(nums[i]);
                if (i - pre <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);  // !!!! do this to all elements, update index for example [1, 0, 1, 1], 1  returns true
        }

        return false;
    }
}
