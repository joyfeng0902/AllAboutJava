package main.java;

/**
 * Created by joyfeng on 12/10/2016.
 */
public class LC153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        // 1) If rotate, A[min] < A[min - 1], then mid is the min number;
        // 2) If not, need to get A[0].
        // use binary search and return nums[low]
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }

            if (nums[mid] < nums[high]) {  // the right side is sorted
                high = mid-1;
            } else {   // the left side is sorted
                low = mid+1;
            }
        }

        return nums[low];
    }
}
