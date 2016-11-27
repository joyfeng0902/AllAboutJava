package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class GoogleLC297SerializeandDeserializeBinaryTree {
    private final String nullNode = "#";
    private final String delimiter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Level Order Traveral
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(String.valueOf(node.val));
                sb.append(delimiter);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append(nullNode);
                sb.append(delimiter);
            }
        }

        sb.deleteCharAt(sb.length()-1); // get rid of the last ,
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        String[] arr = data.split(delimiter);
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // node can be null
            if (node == null) {
                continue;
            }
            if (!arr[i].equals(nullNode)) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
            } else {
                node.left = null;
            }
            queue.offer(node.left);   // !! do not forget to add node.left to queue

            if (!arr[i+1].equals(nullNode)) {
                node.right = new TreeNode(Integer.parseInt(arr[i+1]));
            } else {
                node.right = null;
            }
            queue.offer(node.right);   // !! do not forget to add node.right to queue
            i = i+2;
        }

        return root;
    }

    public static void main(String[] args) {
        GoogleLC297SerializeandDeserializeBinaryTree l = new GoogleLC297SerializeandDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        l.serialize(root);
        l.deserialize(l.serialize(root));

        l = new GoogleLC297SerializeandDeserializeBinaryTree();
        l.deserialize("1,#,2");
    }
}
