package main.java;

/**
 * Created by joyfeng on 1/2/2017.
 */
public class LC395LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int[] counts = new int[26];
        char badChar = 0;
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (0 < counts[i] && counts[i] < k) {   // need to check if it is > 0 too becasue initially it is == 0
                badChar = (char)(i + 'a');  // found a bad char. break.
                break;
            }
        }

        if (badChar == 0) {  // all chars has number >= k
            return s.length();
        }

        int maxLen = 0;
        String[] sub = s.split(badChar + "");
        for (String str : sub) {
            maxLen = Math.max(maxLen, longestSubstring(str, k));
        }
        return maxLen;
    }
}
