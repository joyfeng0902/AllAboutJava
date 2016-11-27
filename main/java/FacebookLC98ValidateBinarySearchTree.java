package main.java;

/**
 * Created by joyfeng on 11/21/2016.
 */
public class FacebookLC98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    boolean helper(TreeNode root, double low, double high) {
        if (root.val <= low || root.val >= high) {
            return false;
        }

        if (root.left != null && !helper(root.left, low, root.val)) {
            return false;
        }

        if (root.right != null && !helper(root.right, root.val, high)) {
            return false;
        }

        return true;
    }
}
