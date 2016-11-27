package main.java;

/**
 * Created by joyfeng on 11/20/2016.
 */
public class FacebookLC311SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int columnA = A[0].length, rowA = A.length, columnB = B[0].length;
        int[][] result = new int[rowA][columnB];
        for (int i = 0; i < rowA; i++) {
            for (int k = 0; k < columnA; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < columnB; j++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }
}
