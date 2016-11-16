package main.java;

/**
 * An edit between two strings is one of the following changes.
     Add a character
     Delete a character
     Change a character
     Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit.
     Expected time complexity is O(m+n) where m and n are lengths of two strings.
 */
public class FacebookLC72EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // create a table to store results of subproblems
        int[][] dp = new int[m+1][n+1];

        for (int j = 0; j <= n; j++) {
            // if word1 is empty, , only option is to
            // insert all characters of second string
            dp[0][j] = j;
        }
        for (int i = 0; i <=m; i++) {
            // if word2 is empty, , only option is to
            // insert all characters of first string
            dp[i][0] = i;
        }
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                // If last char are the same
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {  // the last char is different,
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1],     // replace
                                             dp[i][j-1]),       // insert
                                             dp[i-1][j]);      /// remove
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String args[]) {
        String str1 = "sunday";
        String str2 = "saturday";
        FacebookLC72EditDistance f = new FacebookLC72EditDistance();
        System.out.println(f.minDistance(str1, str2));
    }
}
