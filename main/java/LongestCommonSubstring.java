package main;

// Given two string sequences write an algo­rithm to find, find the length of longest sub­string present in both of them.
// A longest sub­string is a sequence that appears in the same order and necessarily contiguous in both the strings.
// String A = "tutorialhorizon";
// String B = "dynamictutorialProgramming";
// Output: Length of Longest Common Substring: 8 ("tutorial").
public class LongestCommonSubstring {
    // DP
    // Check if the ith char in A = the jth char in B
    // Case 1: both are the same
    // LCS[i][j] = 1 + LCS[i-1][j-1]
    // Case 2: not the same, LCS[i][j] = 0
    // At the end, traverse the matrix and find the maximum element in it, This will the length of Longest Common Substring.
    public static int find(char [] A, char [] B){
        int[][] LCS = new int[A.length][B.length];
        // i == 0, the very first char in A
        for (int j = 0; j < B.length; j++) {
            if (A[0] == B[j]) {
                LCS[0][j] = 1;
            } else {
                LCS[0][j] = 0;
            }
        }

        // j == 0, the very first char in B
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[0]) {
                LCS[i][0] = 1;
            } else {
                LCS[i][0] = 0;
            }
        }

        // fill the rest of the matrix
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {  // A-1 becasue index starts with 0
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = 0;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                result = Math.max(result, LCS[i][j]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String A = "tutorialhorizon";
        String B = "dynamictutorialProgramming";
        System.out.println("LCS length : " + find(A.toCharArray(), B.toCharArray()));
        A = "a";
        B = "abc";
        System.out.println("LCS length : " + find(A.toCharArray(), B.toCharArray()));
    }
}
