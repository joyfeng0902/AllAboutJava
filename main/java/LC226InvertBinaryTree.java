package main.java;

import java.util.Stack;

/**
 * Created by joyfeng on 10/12/2016.
 */
public class LC226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // recursion
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }

    // iterative using stack
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                stack.push(node.left);
                stack.push(node.right);
            }
        }

        return root;
    }
}
