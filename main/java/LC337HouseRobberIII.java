package main.java;

public class LC337HouseRobberIII {
    // DFS of tree
    // recursion
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] result = helper(root);  // result is an array of size 2
        return Math.max(result[0], result[1]);
    }

    public int[] helper(TreeNode root) {
        if (root == null) {   // !! do not forget to check if root is null
            return new int[]{0, 0};
        }
        // index0: when root is selected; index1: when root is not selected
        int[] result = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        result[0] = root.val + left[1] + right[1]; // when root is selected, left and right sub cannot be selected
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);// when root is not selected, both left and right can be selected

        return result;
    }
}
