package main.java;

/**
 * Created by joyfeng on 11/24/2016.
 */
public class FacebookLC79WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                // board[i][j] is the ccurrent element in board
                if (helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean helper(char[][] board, String word, int i, int j, int k) {
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {  // already reached limit, and still find no match, return false
            return false;
        }

        if (word.charAt(k) == board[i][j]) {
            char temp = board[i][j];
            board[i][j] = '#';  // mark that it is already visited
            if (word.length() -1 == k) {
                return true;
            }

            if (helper(board, word, i-1, j, k+1)
                    || helper(board, word, i, j-1, k+1)
                    || helper(board, word, i+1, j, k+1)
                    || helper(board, word, i, j+1, k+1)) {
                return true;
            }
            board[i][j] = temp;
        }

        return false;
    }
}
