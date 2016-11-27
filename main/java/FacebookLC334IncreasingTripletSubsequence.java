package main.java;

/**
 * Created by joyfeng on 11/25/2016.
 */
public class FacebookLC334IncreasingTripletSubsequence {
    // This problem can be converted to be finding if there is a sequence
    // such that the_smallest_so_far < the_second_smallest_so_far < current.
    // We use x, y and z to denote the 3 number respectively.
    //    初始时设置x1 = x2 = INT_MAX ，然后遍历数组,不断的更新x1和x2 具体如下
    //
    //    num <= x1,  此时将x1设置为num
    //    若 x1 < num <= x2，则 把x2 设置为num
    //    x2 < num  说明有解，返回true即可
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;;
        for (int num : nums) {
            int z = num;
            if (z <= x) {
                x = z;
            } else if (z <= y) {  // x < z < y
                y = z;
            } else {  // z > x && z > y
                return  true;
            }
        }

        return false;
    }
}
