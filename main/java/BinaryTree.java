package main.java;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    // root of a binary tree
    Node root;

    BinaryTree() {
        root = null;
    }

    void deleteTree(Node node) {
        if (node == null) return ;
        // delete both subtrees
        deleteTree(node.left);
        deleteTree(node.right);
        // then delete the node
        System.out.println("The deleted node is " + node.data);
        node = null;
    }

    // delete the tree and set root to be null
    void deleteTreeRef(Node node) {
        deleteTree(node);
        node = null;
    }

    void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.println("Node is " + node.data);
        inOrderTraversal(node.right);
    }

    // wrap over above recursive function
    void printInOrderTraversal() {
        inOrderTraversal(root);
    }

    // level order traversal of Binary Tree using Queue
    void printlevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node tmpNode =  queue.poll();     // poll() removes the present head
            System.out.println(tmpNode.data + " ");

            // have to check if tmpNode.left or tmpNode.right is null
            if (tmpNode.left != null)
                queue.add(tmpNode.left);

            if (tmpNode.right != null)
                queue.add(tmpNode.right);
        }
    }

    // leetcode #104. Maximum Depth of Binary Tree
    // using recursion
    int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }

    // leetcode #111. Minimum Depth of Binary Tree
    public int minDepth(Node node) {
        if (node == null) {  // if tree is empty
            return 0;  // base case
        }

        if (node.left == null && node.right == null) {    // if it is only root node
            return 1;  // base case
        }

        // tricky part
        if (node.left == null) {      // if left subtree is empty, get the min of the right subtree
            return minDepth(node.right) + 1;
        }

        if (node.right == null) {
            return minDepth(node.left) + 1;
        }
        return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }

    // Implement a function to check if a tree is balanced. For the purposes of this question,
    // a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
    // from the root by more than one.
    // leetcode #110. Balanced Binary Tree
    boolean isBalanced(Node node) {
        //if (maxDepth(node) - minDepth(node) <= 1) return true;
        //else return false;
        return maxDepth(node) - minDepth(node) <= 1;
    }

    // using recursion
    boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // recursion
        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
    // return root
    Node createMinTree(int[] arrs, int start, int end) {
        if (start > end) {
            return null;
        }
        //int mid = (start + end) / 2;
        int mid = (start + end)>>1;
        Node node = new Node(arrs[mid]);
        node.left = createMinTree(arrs, start, mid - 1);
        node.right = createMinTree(arrs, mid + 1, end);
        return node;
    }

    //    Connect nodes at same level
    //    Write a function to connect all the adjacent nodes at the same level in a binary tree. Structure of the given Binary Tree node is like following.
    //
    //    struct node{
    //        int data;
    //        struct node* left;
    //        struct node* right;
    //        struct node* nextRight;
    //    }
    //    Input Tree
    //    A
    //    / \
    //    B   C
    //    / \   \
    //    D   E   F
    //
    //
    //    Output Tree
    //    A--->NULL
    //    / \
    //    B-->C-->NULL
    //    / \   \
    //    D-->E-->F-->NULL
    // Given a node p, p.left.nextRight = p.right; p.right.nextRight = p.nextRight.left;
    // have to think about if a node is null; also initially root.nextRight = null;

    // set the nextRight node for root, and call connectRecur for other nodes
    void connect(Node p) {
        p.nextRight = null;
        // set nextRight for other nodes
        connectRecur(p);
    }

    void connectRecur(Node p) {
        if (p == null)
            return;   // don't forget! base tree
        if (p.left != null) {
            p.left.nextRight = p.right;
        }
        if (p.right != null) {
            p.right.nextRight = (p.nextRight != null) ? p.nextRight.left : null;
        }
        // in pre-order fashion
        connectRecur(p.left);
        connectRecur(p.right);
    }

    // Find the min value in a binary search tree
    Node minNode(Node p) {
        Node current = p;
        // loop down to find the leftmost leaf
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Inorder Successor in Binary Search Tree
    Node inOrderSuccessor(Node n) {
        if (n == null)
            return null;
        if (n.right != null) {
            // find it in the right subtree
            return minNode(n.right);
        }

        // right subtree is null, traverse down from the root to find the successor
        Node succ = null;
        while (root != null) {
            if (n.data > root.data) {
                // search in the right subtree
                root = root.right;
            } else if (n.data < root.data) {
                // search in the left subtree
                succ = root;
                root = root.left;
            } else {
                break;
            }
        }
        return succ;
    }

    // Lowest Common Ancestor (LCA) in a Binary Search Tree.
    //    while traversing from top to bottom, the first node n we encounter with value
    // between n1 and n2, i.e., n1 < n < n2 or same as one of the n1 or n2, is LCA of n1 and n2
    // (assuming that n1 < n2). So just recursively traverse the BST in, if node’s value is greater
    // than both n1 and n2 then our LCA lies in left side of the node, if it’s is smaller than
    // both n1 and n2, then LCA lies on right side. Otherwise root is LCA
    Node lowestCommonAncestor(Node p, Node n1, Node n2) {
        if (p == null) {
            return null;
        }
        // would complain "no return statement"; so put return p to the end.
        // assume n1 < n2
        //if (n1.data <= p.data && p.data <= n2.data) {
        //    return p;
        //}

        if (n1.data < p.data && n2.data < p.data) {
            return lowestCommonAncestor(p.left, n1, n2);
        }

        if (n1.data > p.data && n2.data > p.data) {
            return lowestCommonAncestor(p.right, n1, n2);
        }

        return p;
    }

    // check if 2 trees with roots as root1 and root2 are identical
    boolean areIdentical(Node root1, Node root2) {
        // base case
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        // check if data of both roots are the same
        // or data of the left or right subtree are the same
        return  (root1.data == root2.data) &&
                areIdentical(root1.left, root2.left) &&
                areIdentical(root1.right, root2.right);
    }

    // check if tree S is a subtree of T
    boolean isSubtree(Node T, Node S) {
        if (S == null)
            return true;
        if (T == null)
            return false;

        if (areIdentical(T, S))
            return true;

        // if doesnot match, try T's left and right subtree one by one
        return isSubtree(T.left, S)
                || isSubtree(T.right, S);

    }

    // TODO
    // Given a directed graph, design an algorithm to find out whether there is a route between two nodes.



    // TODO
    // You are given a binary tree in which each node contains a value. Design an algorithm to print all paths
    // which sum up to that value. Note that it can be any path in the tree - it does not have to start at the root.

    public static void main (String[] args) {
        // create a tree
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.printInOrderTraversal();
        // print all leaf to root path and delete the tree
        tree.deleteTreeRef(tree.root);
        tree.printlevelOrder();
        if (tree.isBalanced(tree.root)) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }

        tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(3);
        if (tree.isBalanced(tree.root)) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }

        int[] arrs = new int[]{1, 2, 3, 4, 5, 6, 7};
        tree = new BinaryTree();
        tree.root = tree.createMinTree(arrs, 0, arrs.length - 1);
        tree.printInOrderTraversal();

        tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(3);
        tree.root.right = new Node(2);
        tree.connect(tree.root);

        tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.right = new Node(11);
        tree.root.left = new Node(9);
        tree.root.left.left = new Node(6);
        tree.root.left.left.right = new Node(8);
        tree.root.left.left.right.left = new Node(7);
        System.out.println("Node " + tree.root.left.left.data + "'s in order successor is "
                + tree.inOrderSuccessor(tree.root.left.left).data);
        System.out.println("Node " + tree.root.left.data + "'s in order successor is "
                + tree.inOrderSuccessor(tree.root.left).data);
        //System.out.println("Node " + tree.root.right.data + "'s in order successor is "
        //        + tree.inOrderSuccessor(tree.root.right).data);

        tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        System.out.println(tree.lowestCommonAncestor(tree.root, tree.root.left, tree.root.right).data);
        System.out.println(
                tree.lowestCommonAncestor(tree.root, tree.root.left.right.left, tree.root.left.right.right).data);
        System.out.println(tree.lowestCommonAncestor(tree.root, tree.root.left, tree.root.left.right.right).data);

        tree = new BinaryTree();
        tree.root = new Node(26);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(3);
        tree.root.left = new Node(10);
        tree.root.left.left = new Node(4);
        tree.root.left.left.right = new Node(30);
        tree.root.left.right = new Node(6);

        BinaryTree subTree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.right = new Node(6);
        tree.root.left = new Node(4);
        tree.root.left.right = new Node(30);

        System.out.println("Is sub tree? " + tree.isSubtree(tree.root, subTree.root));
    }
}
