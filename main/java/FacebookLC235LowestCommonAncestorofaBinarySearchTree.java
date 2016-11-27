package main.java;

/**
 * Created by joyfeng on 11/24/2016.
 */
public class FacebookLC235LowestCommonAncestorofaBinarySearchTree {
    //    很简单的思路就是看两个值在root的哪边：
    //
    //    两个值都在左边，则LCA在左边
    //    两个值都在右边，则LCA在右边
    //    一个在左一个在右，则说明LCA就是当前的root节点。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
