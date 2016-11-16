package main.java;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by joyfeng on 10/12/2016.
 */
public class LC226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        // Time Complexity: Since each node is visited only once
        // Because of recursion, O(h) function calls will be
        // placed on the stack in the worst case, where h is the height of the tree. Because h∈O(n), the space complexity is O(n).
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
    // similar to breath first search
    // we swap left and right child of all nodes in the tree
    // create a queue to store nodes whoes left and right child are not swapped.
    // initially only the root is in the queue
    // as long as queue is not empty, remove the next node from the queue swap its left and right, and add children to the queue
    // Eventually, the queue will be empty and all the children swapped, and we return the original root.

    // Since each node in the tree is visited / added to the queue only once, the time complexity is O(n), where nn is the number of nodes in the tree.
    // Space complexity is O(n), since in the worst case, the queue will contain all nodes in one level of the binary tree.
    // For a full binary tree, the leaf level has O(n) leaves.
    public TreeNode invertTreeUsinngStack(TreeNode root) {
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

    //
    public TreeNode invertTreeUsinngQueue(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return root;
    }
}
