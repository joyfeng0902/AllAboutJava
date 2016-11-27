package main.java;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by joyfeng on 11/20/2016.
 */
public class GoogleLC314BinaryTreeVerticalOrderTraversal {
    // level order traversal
    // a node's left degree: the node's degree-1, right degree: the node's degree+1)
    // keep  a map to store level to node list
    private class TreeColumnNode{
        public TreeNode treeNode;
        int col;
        public TreeColumnNode(TreeNode node, int col) {
            this.treeNode = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeColumnNode> queue = new LinkedList<TreeColumnNode>();
        queue.offer(new TreeColumnNode(root, 0));
        int minLevel = 0;
        int maxLevel = 0;
        // level to list of nodes
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        while (!queue.isEmpty()) {
            TreeColumnNode node = queue.poll();
            minLevel = Math.min(minLevel, node.col);
            maxLevel = Math.max(maxLevel, node.col);

            if (map.containsKey(node.col)) {
                map.get(node.col).add(node.treeNode.val);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(node.treeNode.val);
                map.put(node.col, list);
            }

            if (node.treeNode.left != null) {
                queue.offer(new TreeColumnNode(node.treeNode.left, node.col-1));
            }
            if (node.treeNode.right != null) {
                queue.offer(new TreeColumnNode(node.treeNode.right, node.col+1));
            }
        }

        // process map, to print from the minLevel to maxLevel
        for (int i = minLevel; i <= maxLevel; i++) {
            result.add(map.get(i));
        }

        return result;
    }

}
