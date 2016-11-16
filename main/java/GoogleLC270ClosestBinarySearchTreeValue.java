package main.java;

/**
 * Created by joyfeng on 10/27/2016.
 */
public class GoogleLC270ClosestBinarySearchTreeValue {
    // keep 2 global variables
    // update the values when traversing sub nodes
    double diff = Double.MAX_VALUE;
    int goal;
    public int closestValue(TreeNode root, double target) {
        helper(root, target);

        return goal;
    }

    void helper(TreeNode node, double target) {
        if (node == null) {
            return;
        }
        if (diff > Math.abs(node.val - target)) {
            diff = Math.abs(node.val - target);
            goal = node.val;
        }
        if (target == node.val) {
            return ;
        } else if (target > node.val) {
            helper(node.right, target);
        } else {
            helper(node.left, target);
        }
    }
}
