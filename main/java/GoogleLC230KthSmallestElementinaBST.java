package main.java;

import java.util.Stack;

/**
 * Created by joyfeng on 10/26/2016.
 */
public class GoogleLC230KthSmallestElementinaBST {
    // in-order traversal
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public int kthSmallest(TreeNode root, int k) {
        putAll(root);
        int res = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                res = node.val;
            }
            if (node.right != null) {
                putAll(node.right);
            }
        }

        return res;
    }

    void putAll(TreeNode  node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        GoogleLC230KthSmallestElementinaBST g = new GoogleLC230KthSmallestElementinaBST();
        System.out.print(g.kthSmallest(new TreeNode(1), 1));
    }
}
