package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joyfeng on 11/18/2016.
 */
public class FacebookLC325MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // key: the sum of [nums[0] ... nums[i]]  value: the index i
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 如果有相同的和, 那就不管了, 因为我们要的最长的子串, 肯定是留着前面的一个值更优.
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum-k)) {
                maxLen = Math.max(maxLen, i-map.get(sum-k));
            }
        }
        return maxLen;
    }

    public static void main (String [] args) {
        FacebookLC325MaximumSizeSubarraySumEqualsk f = new FacebookLC325MaximumSizeSubarraySumEqualsk();
        f.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3);
    }
}

