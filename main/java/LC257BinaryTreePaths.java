package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyfeng on 10/7/2016.
 */
public class LC257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(result, root, "");

        return result;
    }

    void helper(List<String> result, TreeNode node, String path) {
        if (node == null) {
            return;
        }

        path = path.equals("") ? String.valueOf(node.val) : path + "->" + node.val;
        if (node.left == null && node.right == null) {
            // leaf
            result.add(path);
            return;
        } else {
            helper(result, node.left, path);
            helper(result, node.right, path);
        }
    }
}
