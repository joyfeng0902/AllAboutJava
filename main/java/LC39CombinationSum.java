package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC39CombinationSum {
    // using depth first search
    // 时间 O(N!) 空间 O(N) 递归栈空间
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new LinkedList<List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, tmp);

        return result;
    }

    void dfs(int[] arr, int target, int start, List<Integer> tmp) {
        if (target < 0) {  // the current sum > target, the path is wrong
            return;
        } else if (target == 0) {   // the correct path
            List<Integer> oneComb = new LinkedList<Integer>(tmp);
            result.add(oneComb);
        } else {  // dfs on the rest elements
            for (int i = start; i < arr.length; i++) {
                // add the element, dfs, and remove the element after recursion
                tmp.add(arr[i]);
                dfs(arr, target - arr[i], i, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
