package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyfeng on 11/26/2016.
 */
public class GoogleLC448FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //  The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].
        // In this way all the numbers that we have seen will be marked as negative.
        // In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, so just add it to the return list.
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            nums[Math.abs(val)-1] = (nums[Math.abs(val)-1]) < 0 ? nums[Math.abs(val)-1] : -nums[Math.abs(val)-1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
