package main;

/*
Given two string sequences, write an algorithm to find the length of longest subsequence present in both of them.

A longest subsequence is a sequence that appears in the same relative order,
but not necessarily contiguous(not sub­string) in both the string.

Example:
String A = "acbaed";
String B = "abcadf";
Longest Common Subsequence(LCS):     acad, Length: 4
// Method 1:
     Case 1:
        String A: "ABCD", String B: "AEBD"
        LCS("ABCD", "AEBD") = 1 + LCS("ABC", "AEB")

    Case 2:
        String A: "ABCDE", String B: "AEBDF"
        LCS("ABCDE", "AEBDF") = Max(LCS("ABCDE", "AEBD"), LCS("ABCD", "AEBDF"))
   Time complexity will O(2^n)
// Method 2: DP
*/
public class LongestCommonSubsequence {
    public int LCS1(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() ==0) {
            return 0;
        }

        int lenA = A.length(), lenB = B.length();
        if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
            return 1 + LCS1(A.substring(0, lenA-1), B.substring(0, lenB-1));
        } else {
            return Math.max(LCS1(A.substring(0, lenA), B.substring(0, lenB-1)),
                    LCS1(A.substring(0, lenA-1), B.substring(0, lenB)));
        }
    }

    public int LCS2(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() ==0) {
            return 0;
        }

        int lenA = A.length(), lenB = B.length();
        int[][] dp = new int[lenA+1][lenB+1];
        for (int i= 0; i < lenA; i++) {      // B is empty
            dp[i][0] = 0;
        }
        for (int j = 0; j < lenB; j++) {     // A is empty
            dp[0][j] = 0;
        }
        for (int i= 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {           // not A.charAt(i) == B.charAt(j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[lenA][lenB];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        System.out.println(l.LCS1("ABCD", "AEBD"));
        System.out.println(l.LCS1("ABCDE", "AEBDF"));


        System.out.println(l.LCS2("ABCD", "AEBD"));
        System.out.println(l.LCS2("ABCDE", "AEBDF"));
        System.out.println(l.LCS2("ACBDEA", "ABCDA"));
    }
}
