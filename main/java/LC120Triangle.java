package main.java;

import java.util.List;

public class LC120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // start from the row above the bottom row to top
        // each number add the smaller number below it
        for (int j = triangle.size()-2; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                triangle.get(j).set(i, triangle.get(j).get(i) + Math.min(triangle.get(j+1).get(i), triangle.get(j+1).get(i+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
