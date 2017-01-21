package main.java;

import java.util.ArrayList;
import java.util.List;

public class LC118PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if (i == 0) {
                list.add(1);
                res.add(list);
            } else {
                List<Integer> prev = res.get(i-1);
                list.add(prev.get(0));
                for (int j = 1; j < prev.size(); j++) {
                    list.add(prev.get(j-1) + prev.get(j));
                }
                list.add(prev.get(prev.size()-1));
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        generate(3);
    }
}
