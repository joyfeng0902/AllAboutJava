package main;

public class FacebookLC91DecodeWays {
    // using DP
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;

        if (Integer.parseInt(s.substring(0,2)) > 26) {
            if (s.charAt(1) > '0') {
                dp[1] = 1;  // for example, "32", dp[0] = 1, dp[1] = 1;
            } else {
                dp[1] = 0;  // for example, "30", dp[0] = 1, dp[1] = 0;
            }
        } else {
            if (s.charAt(1) > '0') {
                dp[1] = 2;  // for example, "25", dp[0] = 1, dp[1] = 2;
            } else {
                dp[1] = 1;  // for example, "20", dp[0] = 1, dp[1] = 1;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) > '0') {
                dp[i] += dp[i-1];
            }
            int val = Integer.parseInt(s.substring(i-1, i+1));
            if (i >= 2 && val >= 10 && val <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        FacebookLC91DecodeWays f = new FacebookLC91DecodeWays();
        f.numDecodings("10");
        f.numDecodings("1");
    }
}
