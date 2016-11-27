package main.java;

/**
 * Created by joyfeng on 11/22/2016.
 */
public class FacebookLC404SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }

        return helper(node.left, true) + helper(node.right, false);
    }
}
