package main.java;

import java.util.ArrayList;
import java.util.List;

public class LC113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, sum, new ArrayList<Integer>());
        return res;
    }

    void helper(List<List<Integer>> res, TreeNode node, int target, List<Integer> tmp) {
        if (node == null) {
            return;
        }
        // must be from root to leaf
        tmp.add(node.val);
        if (node.left == null && node.right == null && target == node.val) {
            res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size()-1);
            return;
        } else {
            helper(res, node.left, target-node.val, tmp);
            helper(res, node.right, target-node.val, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
