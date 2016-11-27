package main.java;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 */
public class FacebookLC285InorderSuccessorinBST {
    //    一种较为通用的方法是中序遍历一遍二叉树,记录结点的前一个结点,这样当前一个结点为p时,当前结点就是p的后继结点.这种方法适用于一般二叉树,时间复杂度为O(n).
    //
    //    但是这种方法并没有利用到二叉搜索树的性质. 因此我们还可以比较给定结点与根结点的大小, 如果根节点的值较大, 说明这个结点在根节点的左边,
    //    因此此时根节点就是其不紧切后继, 然后再往左子树去比较. 如果根节点值较小, 说明我们要找的结点在根节点右边.这样一步步就可以找到最终的后继.
    // in order: left middle right
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 每次当node.val > p.val的时候，我们记录下当前的node节点，然后往左子树查找。
        // 否则向右子树查找。 向右子树查找的过程中不需要更新successor。
        TreeNode node = root, successor = null;
        while (node != null) {
            if (node.val > p.val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return successor;
    }
}
