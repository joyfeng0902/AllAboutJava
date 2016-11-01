package main.java;

public class LC189RotateArray {
    // Intermediate Array
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        int length = nums.length;
        if (k > length) {
            k = k%length;
        }

        int[] newNums = new int[length];
        for (int i = 0; i < k; i++) {
            newNums[i] = nums[length-k+i];
        }
        for (int i = k, j = 0; i < length; i++, j++) {
            newNums[i] = nums[j];
        }

        System.arraycopy(newNums, 0, nums, 0 , length);
    }

    // Bubble Rotate

    // Reversal
    // O(1) space and O(n) time
    //    1. Divide the array two parts: 1,2,3,4 and 5, 6
    //    2. Reverse first part: 4,3,2,1,5,6
    //    3. Reverse second part: 4,3,2,1,6,5
    //    4. Reverse the whole array: 5,6,1,2,3,4
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0|| k < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        int length = nums.length;
        if (k > length) {
            k=k%length;
        }
        reverse(nums, 0, length-k-1);
        reverse(nums, length-k, length-1);
        reverse(nums, 0, length-1);
    }

    void reverse(int[] arr, int left, int right){
        if (arr == null || arr.length == 0) {
            return;
        }

        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
