package main.java;

public class FacebookLC116PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        // the outside loop is to process the whole tree
        while (root != null) {
            TreeLinkNode node = root;
            // this loop is for each level
            while (node != null && root.left != null && root.right != null) {
                node.left.next = node.right;
                if (node.next != null) {     // node is not the last node in the level
                    node.right.next = node.next.left;
                }

                // move to the next node int he same level
                node = node.next;
            }

            // move to the first node of the next level
            root = root.left;
        }
    }
}
