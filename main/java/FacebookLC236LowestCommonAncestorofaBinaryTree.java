package main.java;

/**
 * Created by joyfeng on 11/21/2016.
 */
public class FacebookLC236LowestCommonAncestorofaBinaryTree {
    //    Divide & Conquer
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return (left != null) ? left : right;
        }
    }
}
