package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyfeng on 10/7/2016.
 */
public class GoogleLC257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }

        // call helper recursively
        helper(root, result, null);
        return result;
    }

    void helper(TreeNode node, List<String> result, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            // it is a leaf
            result.add(path == null ? String.valueOf(node.val) : path + "->" + node.val);
        } else {
            if (node.left != null) {
                helper(node.left, result, path == null ? String.valueOf(node.val) : path + "->" + node.val);
            }
            if (node.right != null) {
                helper(node.right, result, path == null ? String.valueOf(node.val) : path + "->" + node.val);
            }
        }
    }
}
