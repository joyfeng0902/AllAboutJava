package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by joyfeng on 10/11/2016.
 */
public class LC94BinaryTreeInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // inorder: left parent right
        // for iterative method we use stack,
        // push the current node to stack, set current= current.left until current is null
        // while stack is not empty
        // a) pop the node, print, and set current = popped -> right
        // b) push the current node to stack and set current = current.left until current is null
        // if current is null and stack is empty, done
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        TreeNode current = root;
        putAll(current);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            putAll(node.right);
        }

        return result;
    }

    void putAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

//    // recursive
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//        helper(root, result);
//
//        return result;
//    }
//
//    void helper(TreeNode p, List<Integer> result) {
//        if (p.left != null) {
//            helper(p.left, result);
//        }
//        result.add(p.val);
//        if (p.right != null) {
//            helper(p.right, result);
//        }
//    }
}
