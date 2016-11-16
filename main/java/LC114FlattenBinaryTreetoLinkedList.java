package main.java;

import java.util.Stack;

/**
 * Created by joyfeng on 11/7/2016.
 */
public class LC114FlattenBinaryTreetoLinkedList {
    // Go down through the left, when right is not null, push right to stack.
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (p != null ||!stack.isEmpty()) {
            if (p.right != null) {
                stack.push(p.right);
            }

            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.isEmpty()) {  // p.;eft is null, append right
                p.right = stack.pop();
            }
            p = p.right;
        }
    }
}
