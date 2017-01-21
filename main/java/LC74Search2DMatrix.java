package main.java;

/**
 * Created by joyfeng on 1/3/2017.
 */
public class LC74Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // treat it like a 1D array
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            int midValue = matrix[mid/n][mid%n];
            if (midValue == target) {
                return true;
            } else if (midValue <= target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (matrix[low/n][low%n] == target || matrix[high/n][high%n] == target) {
            return true;
        }

        return false;
    }
}
