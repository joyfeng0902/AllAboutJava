package main.java;

import java.util.LinkedList;
import java.util.List;

public class LC77Combinations {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tmp = new LinkedList<Integer>();
        dfs(n, k, 1, tmp);
        return result;
    }

    void dfs(int n, int k, int start, List<Integer> tmp) {
        if (tmp.size() == k) {
            List<Integer> oneComb = new LinkedList(tmp);
            result.add(oneComb);
        } else {
            for(int i = start; i <= n; i++) {
                tmp.add(i);
                dfs(n, k, i + 1, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
