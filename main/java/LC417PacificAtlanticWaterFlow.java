package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyfeng on 10/25/2016.
 */
public class LC417PacificAtlanticWaterFlow {
    // 1、分别处理每个海洋，从海洋边缘（每个海洋两条边）开始，一步步的搜索，即从连接海洋的地方还是搜索，哪些节点的高度高于等于自身（反过来就是可以从那里流到自己），如果是，就标记为true，就这样不断搜索下去。最后所有标记为true的位置就是可以流到对应的海洋。
    // 2、找这两个矩阵，同为true的输出，就是都能流到两个海洋的位置
    void flow(boolean[][] passed, int[][] matrix, int i, int j, int m, int n) {
        passed[i][j] = true;
        if (i < m-1 && !passed[i+1][j] && matrix[i+1][j] >= matrix[i][j]) {
            flow(passed, matrix, i+1, j, m, n);
        }
        if (i >= 1 && !passed[i-1][j] && matrix[i-1][j] >= matrix[i][j]) {
            flow(passed, matrix, i-1, j, m, n);
        }
        if (j < n-1 && !passed[i][j+1] && matrix[i][j+1] >= matrix[i][j]) {
            flow(passed, matrix, i, j+1, m, n);
        }
        if (j >= 1 && !passed[i][j-1] && matrix[i][j-1] >= matrix[i][j]) {
            flow(passed, matrix, i, j-1, m, n);
        }
    }
    public List<int[]> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        List<int[]> result  = new ArrayList<int[]>();
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        boolean[][] PV = new boolean[m][n];
        boolean[][] AV = new boolean[m][n];
        // 这里从所有临海的地方到这回去判断某个节点是否能流到对应的地方
        for (int i = 0; i < m; i++) {
            flow(PV, matrix, i, 0, m, n);
            flow(AV, matrix, i, n-1, m, n);
        }

        for (int j = 0; j < n; j++) {
            flow(PV, matrix, 0, j, m, n);
            flow(AV, matrix, m-1, j, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (PV[i][j] && AV[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }
}
