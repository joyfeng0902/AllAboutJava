package main.java;

/**
 * Created by joyfeng on 10/24/2016.
 */
public class GoogleLC200NumberofIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {  // need to check this!!
            return res;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {  // if not visited using BFS and value is 1, it is a island
                    res++;
                    helper(grid, visited, m, n, i, j);
                }
            }
        }

        return res;
    }

    void helper(char[][] grid, boolean[][] visited, int m, int n, int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true;
            helper(grid, visited, m, n, i-1, j);
            helper(grid, visited, m, n, i+1, j);
            helper(grid, visited, m, n, i, j-1);
            helper(grid, visited, m, n, i, j+1);
        }
    }
}
