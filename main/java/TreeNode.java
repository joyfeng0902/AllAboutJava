package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

    // leetcode #101 Symmetric Tree
    // using recursion: left.left = right.right && left.right = right.left
    //               1
    //              / \
    //             2   2
    //            / \ / \
    //            3  4 4  3
    public static boolean isSymmetric (TreeNode root) {
        // true if tree is empty
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left != null && right == null)
                || (left == null && right != null)
                || (left.val != right.val)) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    //    Given two binary trees, write a function to check if they are equal or not.
    //    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        // at least one of them is not null
        if (t1 != null || t2 == null ) return false;
        // neither is null
        return (t1.val == t2.val)
                && isSameTree(t1.left, t2.left)
                && isSameTree(t1.right, t2.right);
    }

    // level order traversal
    // using queue
    // leetcode 102
    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            System.out.print("[");
            // ATTENTION!!
            // you have t assign the size() to a variable;
            // it varies as you add elements
            // or it will cause bug.
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                // add the value to the list
                System.out.print(" " + tmp.val + " ");
                level.add(tmp.val);
                // add left and right tree to the queue
                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
            }
            System.out.print("]");
            result.add(level);
        }

        return result;
    }

    // 112. Path Sum  QuestionEditorial Solution  My Submissions
    // Given a binary tree and a sum, determine if the tree has a root-to-leaf
    // path such that adding up all the values along the path equals the given sum.
    static boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }

        int subsum = sum - node.val;
        if (node.left == null && node.right == null && subsum == 0) {
            return true;
        }

        return hasPathSum(node.left, subsum) || hasPathSum(node.right, subsum);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> all = new ArrayList();
        if (root == null) {
            return all;
        }
        List l = new ArrayList();
        l.add(root.val);     // add the root value


        dfs(root, sum - root.val, all, l);

        return all;
    }

    private static void dfs(TreeNode node, int sum, List<List<Integer>> result, List<Integer> l) {
        if (node.left == null && node.right == null && sum == 0) {   // leaf
            // has to make a copy, otherwise the content may be changed
            ArrayList<Integer> curPath = new ArrayList<Integer>();
            curPath.addAll(l);
            result.add(curPath);
        }

        if (node.left != null) {
            l.add(node.left.val);
            dfs(node.left, sum - node.left.val, result, l);

        }
        if (node.right != null) {
            l.add(node.right.val);
            dfs(node.left, sum - node.right.val, result, l);
        }
    }

    // leetcode#113 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList();
        if (root == null) {
            return list;
        }

        pathSumList(root, sum, list, new ArrayList());
        return list;
    }

    private void pathSumList(TreeNode root, int sum, List result, List l) {
        if (root == null) {
            return;
        }

        l.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ArrayList curr = new ArrayList(l);
            result.add(curr);
        }

        pathSumList(root.left, sum - root.val, result, l);
        pathSumList(root.right, sum - root.val, result, l);

        l.remove(l.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        levelOrder(root);
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);
//
//        System.out.println("Tree is symmetric? " + isSymmetric(root));
//
//        root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(3);
//
//        System.out.println("Tree is symmetric? " + isSymmetric(root));

        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List result = pathSum(root, 22);
    }
}
