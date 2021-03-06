package main.java;

/**
 * Created by joyfeng on 11/7/2016.
 */
public class LC108ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return subArrayBuilder(nums, 0, nums.length - 1);
    }

    private TreeNode subArrayBuilder(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) {
            return new TreeNode(nums[left]);  // !! new TreeNode(left)
        }

        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = subArrayBuilder(nums, left, mid-1);
        root.right = subArrayBuilder(nums, mid+1, right);

        return root;
    }
}
