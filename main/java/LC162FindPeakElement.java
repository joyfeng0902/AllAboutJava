package main.java;

/**
 * Created by joyfeng on 10/27/2016.
 */
public class LC162FindPeakElement {
    public int findPeakElement(int[] nums) {
        // binary seach
        // 如果mid不是peak的话，那么大于它的那一边一定有peak,以为如果一直递增的话，到了边界也一定会有一个peak. 所以每次可以舍去二分之一。
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            } else if (nums[mid] <= nums[mid+1]) {  // peak is on the right part
                low = mid;
            } else {                                // peak is on the left part
                high = mid;
            }
        }

        if (nums[low] > nums[high]) {
            return low;
        } else {
            return high;
        }
    }
}
