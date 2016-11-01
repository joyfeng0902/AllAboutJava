package main.java;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LC173BinarySearchTreeIterator {
    // it is just BST inorder traversal: left middle right
    // iterative
    // using Stack
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public LC173BinarySearchTreeIterator(TreeNode root) {
        putAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = stack.pop();
        if (tmp.right != null) {
            putAll(tmp.right);
        }
        return tmp.val;
    }

    void putAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
