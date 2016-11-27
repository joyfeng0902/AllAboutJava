package main.java;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class GoogleLC173BinarySearchTreeIterator {
    // it is just BST inorder traversal: left middle right
    // 构造BST数的升序的iterator，实质是树的中序遍历。
    //    需要maintain一个stack，首先从root开始push入栈直到最左节点
    //    在遍历过程中，如果某个节点存在右儿子，则继续从右儿子开始push入栈直到其最左节点
    //    题目中的第一个条件是O(h) memory，因为中序遍历的实现中，stack存的左节点，
    //    并且是从root开始到某点结束的左节点和结束点的右儿子的左后代的节点，着说明了stack的大小是O(h)的。
    //    题目中的第二个条件是，平均时间复杂度是O(1)。由于对整棵树的N个节点做了hasNext()调用之后，也就是说，
    //    一共做了N次调用之后，都只把整棵树的N个节点的每个节点遍历了1遍，所以N次调用的时间复杂度是O(N)，平均下来每次就是O(1)。同理对于Next()的调用。
    // iterative
    // using Stack
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public GoogleLC173BinarySearchTreeIterator(TreeNode root) {
        putAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = stack.pop();
        if (tmp.right != null) {
            putAll(tmp.right);
        }
        return tmp.val;
    }

    void putAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
