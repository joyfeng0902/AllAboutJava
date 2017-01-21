package main.java;

/**
 * Created by joyfeng on 11/26/2016.
 */
public class LC463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int p = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i == 0 || grid[i-1][j] == 0) {
                    p++;
                }
                if (i == m-1 || grid[i+1][j] == 0) {
                    p++;
                }
                if (j == 0 || grid[i][j-1] == 0) {
                    p++;
                }
                if (j == n-1 || grid[i][j+1] == 0) {
                    p++;
                }
            }
        }

        return p;
    }
}
