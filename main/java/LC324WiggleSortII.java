package main.java;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 */
public class LC324WiggleSortII {
    // http://buttercola.blogspot.com/2016/01/leetcode-wiggle-sort-ii.html
    // first sort the array, partition it into 2 halves, so the elements in the first half are smaller than the second half
    // then we pick one from the first half, and one from the second half
    // if the number of elements is odd, the middle must be (left+right)/2+1, becasue the last element in the result is alwasy from the smaller half. see [0,1,2] -> [0,2,1] , the 1st half is [0,1], and the second half is [2]
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] temp = new int[n];
        int left = (n-1)/2, right = n-1;
        for (int i = 0; i < n; i++) {
            if ((i&1)== 1) {  // odd
                temp[i] = nums[right--];
            } else {   // even
                temp[i] = nums[left--];
            }
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }

    // using the idea of quick sort
    // put elements that are less than than the median to the left, put the median in the middle, put elements that are more than the median to the right
    public void wiggleSortBetterSolution(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;

        // 1. find the median, return the index of the median
        int median = findMedian(nums, 0, n-1, (n-1)/2);
        // put elements less than median on the left, more than median on the right
        int[] temp = new int[n];
        int left = 0, right = n-1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[median]) {
                temp[left++] = nums[i];
            } else if (nums[i] > nums[median]) {
                temp[right--] = nums[i];
            }
        }

        // add median to the middle
        for (int i = left; i <= right; i++) {
            temp[i] = nums[median];
        }

        // 3. wiggle sort
        left = (n - 1) / 2;
        right = n - 1;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {  // even
                nums[i] = temp[left--];
            } else {
                nums[i] = temp[right--];
            }
        }
    }

    int findMedian(int[] nums, int low, int high, int k) {
        if (low >= high) {
            return low;
        }
        int pivot = partition (nums, low, high);
        if (pivot == k) {
            return pivot;
        }
        if (pivot > k) {
            return findMedian(nums, low, pivot-1, k);
        } else {
            return findMedian(nums, pivot+1, high, k);
        }
    }

    int partition (int[] nums, int low, int high) {
        int pivot = nums[0];
        int i = low+1, j = high;
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }

            while (i <= j && nums[j] >= pivot) {
                j--;
            }

            if (i <= j) {
                swap(nums, i, j);
            }

            swap(nums, low, j);
        }

        return j;
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
