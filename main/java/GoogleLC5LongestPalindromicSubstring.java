package main;

public class GoogleLC5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String longest = s.substring(0, 1);     // longest must be initialized
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            longest = (longest.length() < tmp.length()) ? tmp : longest;
            tmp = helper(s, i, i+1);
            longest = (longest.length() < tmp.length()) ? tmp : longest;
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length()-1 && s.charAt(begin) == s.charAt(end)) {
            begin--;     // expand to the left
            end++;       // expand to the right
        }
        return s.substring(begin+1, end);  // substring starts from begin+1 and ends with end-1
    }

    public static void main(String[] args){
        GoogleLC5LongestPalindromicSubstring g = new GoogleLC5LongestPalindromicSubstring();
        System.out.println(g.longestPalindrome("babad"));
    }
}
