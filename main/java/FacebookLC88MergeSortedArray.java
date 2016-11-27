package main.java;

public class FacebookLC88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // start from the end of num1
        int end = m + n - 1;
        m = m - 1;  // !! the index of the last element is m-1, not m
        n = n - 1;  // !!
        while (m >= 0 || n >= 0) {
            if (m < 0) {
                nums1[end--] = nums2[n--];
            } else if (n < 0) {
                nums1[end--] = nums1[m--];
            }
            else {
                nums1[end] = (nums1[m] >= nums2[n]) ? nums1[m--] : nums2[n--];
                end--;
            }
        }
    }

    public static void main(String[] args) {
        FacebookLC88MergeSortedArray m = new FacebookLC88MergeSortedArray();
        m.merge(new int[]{1}, 1, new int[]{}, 0);
    }
}
