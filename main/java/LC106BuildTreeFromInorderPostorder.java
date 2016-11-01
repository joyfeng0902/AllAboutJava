package main.java;

/**
 * Created by joyfeng on 10/7/2016.
 */
public class LC106BuildTreeFromInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        // find the root in in-order
        int i = 0;
        for (; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                break;
            }
        }

        int[] inorderLeft = new int[i];
        for (int j = 0; j < i; j++) {
            inorderLeft[j] = inorder[j];
        }
        int[] inorderRight = new int[inorder.length-1-i];
        for (int j = i+1, t=0; j < inorder.length;) {
            inorderRight[t++] = inorder[j++];
        }
        int[] postorderLeft = new int[i];
        for (int j = 0; j < i;) {
            postorderLeft[j] = postorder[j];
            j++;
        }
        int[] postorderRight = new int[inorder.length-1-i];
        for (int j = i, t=0; j < postorder.length-1;) {
            postorderRight[t++] = postorder[j++];
        }

        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);

        return root;
    }

    public static void main(String[] args) {
        LC106BuildTreeFromInorderPostorder l = new LC106BuildTreeFromInorderPostorder();
        TreeNode root = l.buildTree(new int[]{2,1,3}, new int[]{2,3,1});
    }
}
