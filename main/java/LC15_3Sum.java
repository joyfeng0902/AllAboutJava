package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joyfeng on 10/13/2016.
 */
public class LC15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i == 0 || nums[i] > nums[i-1]) {
                int low = i+1, high = length-1;
                while(low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum > -nums[i]) {
                        high--;
                    } else if (sum < -nums[i]) {
                        low++;
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        res.add(list);
                        low++;
                        high--;

                        // handle duplicates
                        while(low < high && nums[low-1] == nums[low]) {
                            low++;
                        }
                        while(low < high && nums[high] == nums[high+1]) {
                            high--;
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC15_3Sum l = new LC15_3Sum();
        l.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

}
